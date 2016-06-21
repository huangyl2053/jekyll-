var DBD;
(function (DBD) {
    (function (HikazeiNenkinShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };

            Events.onClick_btnSaiHyoji = function () {
                return "onClick_btnSaiHyoji";
            };
            return Events;
        })();
        HikazeiNenkinShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HikazeiNenkinShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.HikazeiNenkinShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.HikazeiNenkinShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HikazeiNenkinShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihoNo"));
            };

            Controls.prototype.ddlNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNendo"));
            };

            Controls.prototype.radRireki = function () {
                return new UZA.RadioButton(this.convFiledName("radRireki"));
            };

            Controls.prototype.btnSaiHyoji = function () {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            };

            Controls.prototype.linLine1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine1"));
            };

            Controls.prototype.lblHojinHikazeiNenkinJoho = function () {
                return new UZA.Label(this.convFiledName("lblHojinHikazeiNenkinJoho"));
            };

            Controls.prototype.txtShotokuKananGakugo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShotokuKananGakugo"));
            };

            Controls.prototype.dgHikazeiNenkinShokai = function () {
                return new UZA.DataGrid(this.convFiledName("dgHikazeiNenkinShokai"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        HikazeiNenkinShokai.Controls = Controls;
    })(DBD.HikazeiNenkinShokai || (DBD.HikazeiNenkinShokai = {}));
    var HikazeiNenkinShokai = DBD.HikazeiNenkinShokai;
})(DBD || (DBD = {}));
