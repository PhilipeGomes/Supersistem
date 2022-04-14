import './styles.css';

type Props = {
    nome: string;
}


const SeloCategoria = ({nome} : Props) => {
    return (
        <div className="category-badge-container">{nome}</div>
    )
}
export default SeloCategoria;