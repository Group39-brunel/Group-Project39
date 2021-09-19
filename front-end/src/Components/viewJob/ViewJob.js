import React, {useEffect} from "react";
import './viewJob.css';
import Loader from 'react-loader-spinner';
import axios from 'axios';

export default function ViewJob() {
  const [data, updateData] = React.useState([]);

  let isLoading = true;

  useEffect(()=>{
    axios({
      method: 'get',
      url: '/texts',
    }).then(res=>{
      console.log(res);
      updateData(res.data)
    });
  },[]);

  if (data.length > 0) isLoading = false;

  return (
    <div className="container">
      {isLoading ? (
        <Loader type="ThreeDots" color="#2BAD60" height="100" width="100" />
      ) : (
          <table className="table" aria-label="Table">
            <thead>
              <tr>
                <th>Job Ads</th>
              </tr>
            </thead>
            <tbody>
              {data?.map(row => (
                <tr key={row.id}>
                  <td align="left">{row.text}</td>
                </tr>
              ))}
            </tbody>
          </table>
      )}
    </div>
  );
}