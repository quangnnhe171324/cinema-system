import { useEffect, useState } from "react";
import { useParams, Link, useNavigate } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";
import axios from "axios";
import "./InformationMoviesStaff.css";
import SeatCinema from "../../user/movies/SeatCinema";

const InformationMovieStaff = () => {
  const { id } = useParams();
  const [data, setData] = useState([]);
  const [data1, setData1] = useState([]);
  const cinema_name = "tuaann";
  const cinema_id = 1;
  const [showtime, setShowtime] = useState([]);
  const [selectedDate, setSelectedDate] = useState("");
  const [selectedCinema, setSelectedCinema] = useState("");
  const cinema = sessionStorage.setItem("cinema", cinema_name);
  const cinema1 = sessionStorage.setItem("cinemaid", cinema_id);

  const datelist = [
    {
      date: "2023-07-19",
    },
    {
      date: "2023-07-20",
    },
    {
      date: "2023-07-21",
    },
    {
      date: "2023-07-22",
    },
    {
      date: "2023-07-23",
    },
  ];

  const handleDateChange = (event) => {
    setSelectedDate(event.target.value);
  };

  const movieId = sessionStorage.setItem("movieid", id);
  const [startTime, setStartTime] = useState("");
  const handleTicketClick = (date, cinema_name, showtime, movieName) => {
    // Save values to session storage
    setStartTime(showtime);
    sessionStorage.setItem("date", date);
    sessionStorage.setItem("cinema_name", cinema_name);
    sessionStorage.setItem("time", showtime);
    sessionStorage.setItem("movie", movieName);
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/movie/listMovie/" + id)
      .then((res) => {
        setData(res.data);
      })
      .catch((err) => {
        console.log(err.message);
      });
  }, [id]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/showtime/starttime", {
        params: {
          movieid: id,
          cinemaid: cinema_id,
          startdate: selectedDate,
        },
      })
      .then((res) => {
        setShowtime(res.data);
      })
      .catch((err) => {
        console.log(err.message);
      });
  }, [id, selectedCinema, selectedDate]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/showtime", {
        params: {
          movieid: id,
          cinemaid: cinema_id,
          starttime: startTime,
          startdate: selectedDate,
        },
      })
      .then((res) => {
        setData1(res.data[0]);
      })
      .catch((err) => {
        console.log(err.message);
      });
  }, [id, selectedCinema, startTime, selectedDate]);
  const showtimeid = sessionStorage.setItem("showtimeid", data1?.id);

  return (
    <>
      <Container>
        <Row>
          <div style={{ textAlign: "center" }}>
            <h1>{data?.movie?.name}</h1>
          </div>
          <Col className="my-4">
            <Row className="mt-4">
              <Col md={3}>
                <h4>Select Date: </h4>
                <select
                  style={{
                    height: "40px",
                    width: "100%",
                    paddingLeft: "10px",
                  }}
                  onChange={handleDateChange}
                  value={selectedDate}
                >
                  <option value="">Chọn ngày</option>
                  {datelist.map((dateitem) => (
                    <option key={dateitem.date} value={dateitem.date}>
                      {dateitem.date}
                    </option>
                  ))}
                </select>
              </Col>
              <Col md={3}>
                <h4>Select ShowTime:</h4>
                {selectedDate && (
                  <Col xs={2}>
                    {showtime.map((showtimeitem) => (
                      <span className="ml-3" key={showtimeitem.showtimeid}>
                        {" "}
                        <Button
                          onClick={() =>
                            handleTicketClick(
                              selectedDate,
                              cinema_name,
                              showtimeitem,
                              data?.movie?.name
                              // Thêm cinemaid vào session storage
                            )
                          }
                          style={{ border: "1px solid black" }}
                          variant="light"
                        >
                          {showtimeitem}
                        </Button>
                      </span>
                    ))}
                  </Col>
                )}
              </Col>
            </Row>
          </Col>
        </Row>
      </Container>
      <SeatCinema />
    </>
  );
};

export default InformationMovieStaff;
