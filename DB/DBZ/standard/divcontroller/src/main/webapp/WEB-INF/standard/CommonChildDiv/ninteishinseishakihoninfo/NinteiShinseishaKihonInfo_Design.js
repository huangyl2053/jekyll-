var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaKihonInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NinteiShinseishaKihonInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseishaKihonInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseishaKihonInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseishaKihonInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseishaKihonInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtHihokenshaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaKubun"));
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.txtHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            };

            Controls.prototype.txtHihokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaName"));
            };

            Controls.prototype.txtSeinenYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeinenYmd"));
            };

            Controls.prototype.txtHihokenshaKana = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaKana"));
            };

            Controls.prototype.txtNenrei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNenrei"));
            };

            Controls.prototype.txtSeibetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtSeibetsu"));
            };

            Controls.prototype.txtYubibNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubibNo"));
            };

            Controls.prototype.txtjusho = function () {
                return new UZA.TextBox(this.convFiledName("txtjusho"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtNinteiShinseibi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShinseibi"));
            };

            Controls.prototype.txtShinseiKubunShinseiji = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinseiji"));
            };

            Controls.prototype.txtShinseiKubunHoreiji = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunHoreiji"));
            };
            return Controls;
        })();
        NinteiShinseishaKihonInfo.Controls = Controls;
    })(DBZ.NinteiShinseishaKihonInfo || (DBZ.NinteiShinseishaKihonInfo = {}));
    var NinteiShinseishaKihonInfo = DBZ.NinteiShinseishaKihonInfo;
})(DBZ || (DBZ = {}));
