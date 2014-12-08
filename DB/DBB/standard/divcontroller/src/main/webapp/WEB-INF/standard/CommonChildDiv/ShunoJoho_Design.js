var DBB;
(function (DBB) {
    (function (ShunoJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShunoJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShunoJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.ShunoJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.ShunoJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShunoJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtChoteiNendo = function () {
                return new UZA.TextBox(this.convFiledName("txtChoteiNendo"));
            };

            Controls.prototype.txtFukaNendo = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaNendo"));
            };

            Controls.prototype.txtTsuchiNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTsuchiNo"));
            };

            Controls.prototype.ddlChoteiNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChoteiNendo"));
            };

            Controls.prototype.ddlFukaNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            };

            Controls.prototype.btnNendoChange = function () {
                return new UZA.Button(this.convFiledName("btnNendoChange"));
            };

            Controls.prototype.ShunoJohoTokucho = function () {
                return new UZA.Panel(this.convFiledName("ShunoJohoTokucho"));
            };

            Controls.prototype.dgTokucho = function () {
                return new UZA.DataGrid(this.convFiledName("dgTokucho"));
            };

            Controls.prototype.txtTokuChoteiGeoukei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokuChoteiGeoukei"));
            };

            Controls.prototype.txtTokuShunyuGeoukei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokuShunyuGeoukei"));
            };

            Controls.prototype.ShunoJohoFucho = function () {
                return new UZA.Panel(this.convFiledName("ShunoJohoFucho"));
            };

            Controls.prototype.dgFucho = function () {
                return new UZA.DataGrid(this.convFiledName("dgFucho"));
            };

            Controls.prototype.txtFuChoteiGeoukei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFuChoteiGeoukei"));
            };

            Controls.prototype.txtFuShunyuGeoukei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFuShunyuGeoukei"));
            };
            return Controls;
        })();
        ShunoJoho.Controls = Controls;
    })(DBB.ShunoJoho || (DBB.ShunoJoho = {}));
    var ShunoJoho = DBB.ShunoJoho;
})(DBB || (DBB = {}));
