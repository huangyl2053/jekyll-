var DBD;
(function (DBD) {
    (function (FutanGendogakuNintei) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgFutanGendogakuNinteiList = function () {
                return "onSelect_dgFutanGendogakuNinteiList";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        FutanGendogakuNintei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "FutanGendogakuNintei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.FutanGendogakuNintei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.FutanGendogakuNintei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.FutanGendogakuNintei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHiddenHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHiddenHihokenshaNo"));
            };

            Controls.prototype.dgFutanGendogakuNinteiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgFutanGendogakuNinteiList"));
            };

            Controls.prototype.FutanGendogakuNinteiDetail = function () {
                return new UZA.Panel(this.convFiledName("FutanGendogakuNinteiDetail"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.FutanGendogakuNinteiRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("FutanGendogakuNinteiDetail_FutanGendogakuNinteiRiyoshaFutan"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.txtKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtYukokigenDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            };

            Controls.prototype.txtKyushochisha = function () {
                return new UZA.TextBox(this.convFiledName("txtKyushochisha"));
            };

            Controls.prototype.txtFutanDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtFutanDankai"));
            };

            Controls.prototype.txtKyoshitsuType = function () {
                return new UZA.TextBox(this.convFiledName("txtKyoshitsuType"));
            };

            Controls.prototype.txtKyokaiso = function () {
                return new UZA.TextBox(this.convFiledName("txtKyokaiso"));
            };

            Controls.prototype.txtGekihenKanwa = function () {
                return new UZA.TextBox(this.convFiledName("txtGekihenKanwa"));
            };

            Controls.prototype.FutanGendogaku = function () {
                return new UZA.Panel(this.convFiledName("FutanGendogakuNinteiDetail_FutanGendogakuNinteiRiyoshaFutan_FutanGendogaku"));
            };

            Controls.prototype.txtShokuhi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuhi"));
            };

            Controls.prototype.txtUnitKoshitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitKoshitsu"));
            };

            Controls.prototype.txtUnitJunKoshitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitJunKoshitsu"));
            };

            Controls.prototype.txtTashoshitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTashoshitsu"));
            };

            Controls.prototype.txtJuraigataKoshitsuTokuyo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuTokuyo"));
            };

            Controls.prototype.txtJuraigataKoshitsuRoken = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuRoken"));
            };

            Controls.prototype.txtFushoninRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        FutanGendogakuNintei.Controls = Controls;
    })(DBD.FutanGendogakuNintei || (DBD.FutanGendogakuNintei = {}));
    var FutanGendogakuNintei = DBD.FutanGendogakuNintei;
})(DBD || (DBD = {}));
