import React, { Component } from "react";

import "./../App.css";

import algoliasearch from "algoliasearch/lite";
import {
  InstantSearch,
  SearchBox,
  Hits,
  Highlight,
} from "react-instantsearch-dom";

class Home extends Component {
  state = {};

  handleClick(id) {
    alert(id);
  }

  render() {
    const searchClient = algoliasearch(
      "AHNGOF29I6",
      "e2ab4ce4abffa4700f1bbcc62a2b4e40"
    );

    const Hit = ({ hit }) => {
      return (
        <div className="hit">
          <div className="hit-image">
            <img src={hit.foto} alt={hit.nombre} />
          </div>
          <div className="hit-content">
            <Highlight attribute="nombre" hit={hit} />
            <div className="hit-price">$ {hit.precio}</div>
          </div>
          <div className="hit-botton">
            <button
              className="btn waves-effect waves-light"
              onClick={() => {
                this.handleClick(hit.objectID);
              }}
            >
              Comprar
            </button>
          </div>
        </div>
      );
    };

    return (
      <div className="App">
        <div></div>

        <InstantSearch searchClient={searchClient} indexName="products_NAME">
          <header className="header">
            <SearchBox
              translations={{ placeholder: "Busqueda de Productos" }}
            />
          </header>
          <main>
            <div className="content">
              <Hits hitComponent={Hit} />
            </div>
          </main>
        </InstantSearch>
      </div>
    );
  }
}

export default Home;
