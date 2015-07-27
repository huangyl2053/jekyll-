var DBE;
(function (DBE) {
    (function (HanteiKekkaIchiranShinsakaiPrint) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        HanteiKekkaIchiranShinsakaiPrint.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HanteiKekkaIchiranShinsakaiPrint";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.HanteiKekkaIchiranShinsakaiPrint.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.HanteiKekkaIchiranShinsakaiPrint.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HanteiKekkaIchiranShinsakaiPrint = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtNinteiShinsakaiName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinsakaiName"));
            };

            Controls.prototype.chkPrintTaisho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkPrintTaisho"));
            };

            Controls.prototype.chkShinsaGijiroku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShinsaGijiroku"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnInsatsuChohyo = function () {
                return new UZA.Button(this.convFiledName("btnInsatsuChohyo"));
            };
            return Controls;
        })();
        HanteiKekkaIchiranShinsakaiPrint.Controls = Controls;
    })(DBE.HanteiKekkaIchiranShinsakaiPrint || (DBE.HanteiKekkaIchiranShinsakaiPrint = {}));
    var HanteiKekkaIchiranShinsakaiPrint = DBE.HanteiKekkaIchiranShinsakaiPrint;
})(DBE || (DBE = {}));
