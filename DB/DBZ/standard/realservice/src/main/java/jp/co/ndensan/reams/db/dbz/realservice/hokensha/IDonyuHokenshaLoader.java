/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.business.hokensha.IDonyuHokensha;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.db.dbz.model.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dbz.model.hokensha.IHokensha;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 導入保険者の情報を業務Configから取得します。
 *
 * @author N3327 三浦 凌
 */
public class IDonyuHokenshaLoader {

    public IDonyuHokenshaLoader() {
    }

    /**
     * 業務Configから{@link IDonyuHokensha 導入保険者情報}を取得して返します。
     *
     * @return {@link IDonyuHokensha 導入保険者情報}
     */
    public IDonyuHokensha load() {
        return new _DonyuHokensha();
    }

    private static final class _DonyuHokensha implements IDonyuHokensha {

        private final HokenshaJohoConfig hokenshaJoho;
        private final IHokensha hokensha;
        private final HokenshaName hokenshaName;
        private final HokenshaKosei hokenshaKosei;
        private final boolean isKoikiHokensha;

        private _DonyuHokensha() {
            this.hokenshaJoho = new HokenshaJohoConfig();
            this.hokensha = new Hokensha.Builder(ShoKisaiHokenshaNo.EMPTY)
                    .yubinNo(hokenshaJoho.get郵便番号())
                    .jusho(hokenshaJoho.get保険者住所())
                    .telNo(hokenshaJoho.get電話番号()).build();
            this.hokenshaName = hokenshaJoho.get保険者名();
            this.hokenshaKosei = hokenshaJoho.get保険者構成();
            this.isKoikiHokensha = (this.hokenshaKosei == HokenshaKosei.広域市町村);
        }

        @Override
        public HokenshaName get保険者名() {
            return this.hokenshaName;
        }

        @Override
        public boolean is広域保険者() {
            return this.isKoikiHokensha;
        }

        @Override
        public HokenshaKosei get保険者構成() {
            return this.hokenshaKosei;
        }

        @Override
        public ShoKisaiHokenshaNo get証記載保険者番号() {
            return this.hokensha.get証記載保険者番号();
        }

        @Override
        public AtenaJusho get住所() {
            return this.hokensha.get住所();
        }

        @Override
        public YubinNo get郵便番号() {
            return this.hokensha.get郵便番号();
        }

        @Override
        public TelNo get電話番号() {
            return this.hokensha.get電話番号();
        }

        @Override
        public GunNamePrint get群名印字有無() {
            return this.hokensha.get群名印字有無();
        }

        @Override
        public TodofukenNamePrint get都道府名印字有無() {
            return this.hokensha.get都道府名印字有無();
        }

        @Override
        public ShichosonNamePrint get市町村名印字有無() {
            return this.hokensha.get市町村名印字有無();
        }

        @Override
        public KatagakiPrint get方書印字有無() {
            return this.hokensha.get方書印字有無();
        }

        @Override
        public HowToEditJusho get印字住所編集方法() {
            return this.hokensha.get印字住所編集方法();
        }
    }
}
