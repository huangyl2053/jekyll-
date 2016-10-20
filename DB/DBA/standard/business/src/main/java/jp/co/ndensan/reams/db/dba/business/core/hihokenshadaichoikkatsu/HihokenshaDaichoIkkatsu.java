/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichoikkatsu;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaDaichoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者台帳発行のビジネスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class HihokenshaDaichoIkkatsu {

    private static final RString TITLE = new RString("介護保険　被保険者台帳");
    private static final RString HIHOKENSHANOTITLE = new RString("被保険者番号");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_03 = new RString("03");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_05 = new RString("05");
    private static final RString STATE_適用除外者 = new RString("適用除外者");
    private static final RString STATE_他市町村住所地特例者 = new RString("他市町村住所地特例者");
    private static final RString STATE_資格取得者 = new RString("資格取得者");
    private static final RString STATE_資格喪失者 = new RString("資格喪失者");
    private static final RString SOCHIHOKENSHATITLE = new RString("措置保険者");
    private static final RString KYUHOKENSHATITLE = new RString("旧保険者");
    private static final RString JUSHO_TITLE = new RString("住所");
    private static final RString GYOSEIKU_TITLE = new RString("行政区");
    private static final RString NYUSHOSHISETSUSHURUI_11 = new RString("11");
    private static final RString TELEPHONENOTITLE = new RString("連絡先");

    /**
     * 被保険者Entityの設定メッソドです。
     *
     * @param entity HihokenshaDaichoRelateEntity
     * @return HihokenshaEntity
     */
    public HihokenshaEntity set被保険者Entity(HihokenshaDaichoRelateEntity entity) {
        DbT1001HihokenshaDaichoEntity dbT1001Entity = entity.getDbT100Entity();
        HihokenshaEntity 被保険者Entity = new HihokenshaEntity();
        被保険者Entity.setPrintDate(RDateTime.now());
        被保険者Entity.setPage(RString.EMPTY);
        被保険者Entity.setTitle(TITLE);
        被保険者Entity.setShichosonCode(dbT1001Entity.getShichosonCode());
        被保険者Entity.setHihokenshaNoTitle(HIHOKENSHANOTITLE);
        被保険者Entity.setHihokenshaNo(dbT1001Entity.getHihokenshaNo());
        UaFt200FindShikibetsuTaishoEntity 識別対象Entity = entity.getUaFt200Entity();
        if (識別対象Entity != null) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(識別対象Entity);
            IKojin iKojin = shikibetsuTaisho.to個人();
            被保険者Entity.setKanaMeisho(shikibetsuTaisho.get名称().getKana());
            被保険者Entity.setMeisho(shikibetsuTaisho.get名称().getName());
            被保険者Entity.setSeinengappiYMD(iKojin.get生年月日().toFlexibleDate());
            被保険者Entity.setSeibetsuCode(iKojin.get性別().getCode());
            被保険者Entity.setSetaiCode(iKojin.get世帯コード());
            被保険者Entity.setShikibetsuCode(iKojin.get識別コード());
            IGyoseiKukaku iGyoseiKukaku = iKojin.get行政区画();
            被保険者Entity.setChikucodeTitle1(iGyoseiKukaku.getChiku1().get名称());
            被保険者Entity.setChikuCode1(iGyoseiKukaku.getChiku1().getコード());
            被保険者Entity.setChikucodeTitle2(iGyoseiKukaku.getChiku2().get名称());
            被保険者Entity.setChikuCode2(iGyoseiKukaku.getChiku2().getコード());
            被保険者Entity.setChikucodeTitle3(iGyoseiKukaku.getChiku3().get名称());
            被保険者Entity.setChikuCode3(iGyoseiKukaku.getChiku3().getコード());
            被保険者Entity.setZenkokuJushoCode(iKojin.get住所().get全国住所コード() != null
                    ? iKojin.get住所().get全国住所コード().value() : RString.EMPTY);
            被保険者Entity.setGyoseikuCode(iGyoseiKukaku.getGyoseiku().getコード());
            被保険者Entity.setTelephoneNo1(iKojin.get連絡先１().value());
            被保険者Entity.setJusho(shikibetsuTaisho.get住所().get住所());
        }
        被保険者Entity.setTelephoneNoTitle(TELEPHONENOTITLE);
        被保険者Entity.setJushoTitle(JUSHO_TITLE);
        被保険者Entity.setGyoseikuTitle(GYOSEIKU_TITLE);
        被保険者Entity.setTelephoneNo2(RString.EMPTY);
        被保険者Entity.setSochiHokenshaTitle(SOCHIHOKENSHATITLE);
        被保険者Entity.setKyuHokenshaTitle(KYUHOKENSHATITLE);
        被保険者Entity.setState(get状態(dbT1001Entity));
        ShisetsuNyutaishoEntity 入所施設Entity = entity.get入所施設Entity();
        if (入所施設Entity != null) {
            被保険者Entity.setJigyoshaNo(入所施設Entity.getJigyoshaNo());
            if (NYUSHOSHISETSUSHURUI_11.equals(入所施設Entity.getNyushoShisetsuShurui())) {
                被保険者Entity.setJigyoshaMeisho(入所施設Entity.getJigyoshaName());
            }
            被保険者Entity.setJigyoshaMeisho(!RString.isNullOrEmpty(入所施設Entity.getJigyoshaMeisho())
                    ? new AtenaMeisho(入所施設Entity.getJigyoshaMeisho()) : AtenaMeisho.EMPTY);
            被保険者Entity.setIryoHokenShubetsu(入所施設Entity.getIryoHokenShubetsuCode());
            被保険者Entity.setIryoHokenshaMeisho(入所施設Entity.getIryoHokenshaMeisho());
            被保険者Entity.setIryoHokenKigoNo(入所施設Entity.getIryoHokenKigoNo());
        }
        return 被保険者Entity;
    }

    private RString get状態(DbT1001HihokenshaDaichoEntity entity) {
        RString 資格喪失事由コード = entity.getShikakuSoshitsuJiyuCode();
        RString state;
        if (SHIKAKUSOSHITSUJIYUCODE_03.equals(資格喪失事由コード)) {
            state = STATE_適用除外者;
        } else if (SHIKAKUSOSHITSUJIYUCODE_05.equals(資格喪失事由コード)) {
            state = STATE_他市町村住所地特例者;
        } else if (資格喪失事由コード == null) {
            state = STATE_資格取得者;
        } else {
            state = STATE_資格喪失者;
        }
        return state;
    }

    /**
     * 帳票分類ID「DBA200002_HihokenshaDaichoHakkoIchiranhyo」被保険者台帳一覧表出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho_gyoseikuCode\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
