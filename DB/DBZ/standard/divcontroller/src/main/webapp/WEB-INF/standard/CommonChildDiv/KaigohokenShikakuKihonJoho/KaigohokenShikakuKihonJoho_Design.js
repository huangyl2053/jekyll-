var DBZ;
(function (DBZ) {
    (function (KaigohokenShikakuKihonJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigohokenShikakuKihonJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigohokenShikakuKihonJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigohokenShikakuKihonJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigohokenShikakuKihonJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigohokenShikakuKihonJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.gdKaigoHokenShikakuKihonJoho = function () {
                return new UZA.DataGrid(this.convFiledName("gdKaigoHokenShikakuKihonJoho"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };
            return Controls;
        })();
        KaigohokenShikakuKihonJoho.Controls = Controls;
    })(DBZ.KaigohokenShikakuKihonJoho || (DBZ.KaigohokenShikakuKihonJoho = {}));
    var KaigohokenShikakuKihonJoho = DBZ.KaigohokenShikakuKihonJoho;
})(DBZ || (DBZ = {}));
