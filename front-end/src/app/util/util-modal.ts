import { Modal } from "bootstrap";

export class UtilModal {

    static modal: Modal;

    static show(show: boolean, id: string): void {
        if (show) {
            this.modal = new bootstrap.Modal(document.getElementById(id), {
                keyboard: false
              });
              this.modal?.show();
        } else {
            this.modal?.hide();
        }
    }

    static change(idCurrent: string, idToChange: string): void {
        this.show(false, idCurrent);
        this.show(true, idToChange);
    }
}