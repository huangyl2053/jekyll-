/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoHeaderItem;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaicho.HihokenshaDaichoIchiranHyoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者台帳発行のビジネスです。
 *
 * @reamsid_L DBA-0510-040 duanzhanli
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
    private final List<DbT1001HihokenshaDaichoEntity> 被保険者台帳管理EntityList;
    private final List<ShisetsuNyutaishoEntity> 生活保護受給者EntityList;
    private final List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢福祉年金受給者EntityList;
    private final List<DbT7037ShoKofuKaishuEntity> 証交付回収EntityList;
    private final ShutsuryokujunRelateEntity 出力順Entity;

    /**
     * 被保険者ビジネスコートマスタです。
     *
     * @param 被保険者台帳管理EntityList 被保険者台帳管理EntityList
     * @param 生活保護受給者EntityList 生活保護受給者EntityList
     * @param 老齢福祉年金受給者EntityList 老齢福祉年金受給者EntityList
     * @param 証交付回収EntityList 証交付回収EntityList
     * @param 出力順Entity 出力順Entity
     */
    public HihokenshaDaichoIkkatsu(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳管理EntityList,
            List<ShisetsuNyutaishoEntity> 生活保護受給者EntityList,
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢福祉年金受給者EntityList,
            List<DbT7037ShoKofuKaishuEntity> 証交付回収EntityList,
            ShutsuryokujunRelateEntity 出力順Entity) {
        this.被保険者台帳管理EntityList = 被保険者台帳管理EntityList;
        this.生活保護受給者EntityList = 生活保護受給者EntityList;
        this.老齢福祉年金受給者EntityList = 老齢福祉年金受給者EntityList;
        this.証交付回収EntityList = 証交付回収EntityList;
        this.出力順Entity = 出力順Entity;
    }

    /**
     * 被保険者Entityの設定メッソドです。
     *
     * @param entity HihokenshaDaichoRelateEntity
     * @return HihokenshaEntity
     */
    public HihokenshaEntity set被保険者Entity(ShisetsuNyutaishoEntity entity) {
        DbT1001HihokenshaDaichoEntity dbT1001Entity = entity.get被保険者台帳管理Entity();
        DbT1008IryohokenKanyuJokyoEntity 医療保険Entity = entity.get保険医療保険加入状況Entity();
        UaFt200FindShikibetsuTaishoEntity 識別対象Entity = entity.get宛名Entity();
        HihokenshaEntity 被保険者Entity = new HihokenshaEntity();
        被保険者Entity.setPrintDate(RDateTime.now());
        被保険者Entity.setPage(RString.EMPTY);
        被保険者Entity.setTitle(TITLE);
        被保険者Entity.setShichosonCode(dbT1001Entity.getShichosonCode());
        被保険者Entity.setHihokenshaNoTitle(HIHOKENSHANOTITLE);
        被保険者Entity.setHihokenshaNo(dbT1001Entity.getHihokenshaNo());
        被保険者Entity.setShikibetsuCode(dbT1001Entity.getShikibetsuCode());
        if (識別対象Entity != null) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(識別対象Entity);
            IKojin iKojin = shikibetsuTaisho.to個人();
            被保険者Entity.setKanaMeisho(shikibetsuTaisho.get名称().getKana());
            被保険者Entity.setMeisho(shikibetsuTaisho.get名称().getName());
            被保険者Entity.setSeinengappiYMD(iKojin.get生年月日().toFlexibleDate());
            被保険者Entity.setSeibetsuCode(Seibetsu.toValue(iKojin.get性別().getCode()).get名称());
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
        被保険者Entity.setJigyoshaNo(entity.getJigyoshaNo());
        if (NYUSHOSHISETSUSHURUI_11.equals(entity.getNyushoShisetsuShurui())) {
            被保険者Entity.setJigyoshaMeisho(entity.getJigyoshaName());
        }
        if (!RString.isNullOrEmpty(entity.getJigyoshaMeisho())) {
            被保険者Entity.setJigyoshaMeisho(new AtenaMeisho(entity.getJigyoshaMeisho()));
        }
        if (医療保険Entity != null) {
            被保険者Entity.setIryoHokenShubetsu(医療保険Entity.getIryoHokenShubetsuCode());
            被保険者Entity.setIryoHokenshaMeisho(医療保険Entity.getIryoHokenshaMeisho());
            被保険者Entity.setIryoHokenKigoNo(医療保険Entity.getIryoHokenKigoNo());
        }

        被保険者Entity.setDbT1001HihokenshaDaichoEntityList(get被保険者台帳管理(dbT1001Entity));
        被保険者Entity.setShisetsuNyutaishoEntityList(get生活保護受給者(dbT1001Entity));
        被保険者Entity.setDbT7006RoreiFukushiNenkinJukyushaEntityList(get老齢福祉年金受給者(dbT1001Entity));
        被保険者Entity.setDbT7037ShoKofuKaishuEntityList(get証交付回収(dbT1001Entity));
        return 被保険者Entity;
    }

    private List<DbT1001HihokenshaDaichoEntity> get被保険者台帳管理(DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        List<DbT1001HihokenshaDaichoEntity> dbT1001EntityList = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : 被保険者台帳管理EntityList) {
            if (dbT1001Entity.getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                dbT1001EntityList.add(entity);
            }
        }
        return dbT1001EntityList;
    }

    private List<ShisetsuNyutaishoEntity> get生活保護受給者(DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        List<ShisetsuNyutaishoEntity> shisetsuNyutaishoEntityList = new ArrayList<>();
        for (ShisetsuNyutaishoEntity entity : 生活保護受給者EntityList) {
            if (dbT1001Entity.getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                shisetsuNyutaishoEntityList.add(entity);
            }
        }
        return shisetsuNyutaishoEntityList;
    }

    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> get老齢福祉年金受給者(DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006EntityList = new ArrayList<>();
        for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : 老齢福祉年金受給者EntityList) {
            if (dbT1001Entity.getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                dbT7006EntityList.add(entity);
            }
        }
        return dbT7006EntityList;
    }

    private List<DbT7037ShoKofuKaishuEntity> get証交付回収(DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        List<DbT7037ShoKofuKaishuEntity> dbT7037EntityList = new ArrayList<>();
        for (DbT7037ShoKofuKaishuEntity entity : 証交付回収EntityList) {
            if (dbT1001Entity.getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                dbT7037EntityList.add(entity);
            }
        }
        return dbT7037EntityList;
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
     * 帳票_保険者台帳発行一覧表HeadItemの設定メッソドです。
     *
     * @param entity entity
     * @return HihokenshaDaichoHakkoIchiranhyoHeaderItem
     */
    public HihokenshaDaichoHakkoIchiranhyoHeaderItem setHeadItem(HihokenshaDaichoIchiranHyoRelateEntity entity) {
        return new HihokenshaDaichoHakkoIchiranhyoHeaderItem(
                entity.get市町村ID().value(),
                entity.get市町村名称(),
                出力順Entity.get出力順1(),
                出力順Entity.get出力順2(),
                出力順Entity.get出力順3(),
                出力順Entity.get出力順4(),
                出力順Entity.get出力順5(),
                出力順Entity.get改頁項目1(),
                出力順Entity.get改頁項目2(),
                出力順Entity.get改頁項目3(),
                出力順Entity.get改頁項目4(),
                出力順Entity.get改頁項目5());
    }

    /**
     * 帳票_保険者台帳発行一覧表BodyItemの設定メッソドです。
     *
     * @param entity entity
     * @return HihokenshaDaichoHakkoIchiranhyoBodyItem
     */
    public HihokenshaDaichoHakkoIchiranhyoBodyItem setBodyItem(HihokenshaDaichoIchiranHyoRelateEntity entity) {
        return new HihokenshaDaichoHakkoIchiranhyoBodyItem(
                entity.get被保険者番号().value(),
                get氏名カナ(entity.get氏名カナ()),
                entity.get性別(),
                entity.get年齢(),
                get行政区(entity.get行政区()),
                get郵便番号(entity.get郵便番号()),
                get識別コード(entity.get識別コード()),
                entity.get状態区分(),
                entity.get生保(),
                entity.get備考(),
                get氏名(entity.get氏名()),
                entity.get生年月日(),
                entity.get住所(),
                get世帯コード(entity.get世帯コード()),
                entity.get資格区分(),
                entity.get老福(),
                entity.get番地コード(),
                entity.get町域コード(),
                entity.get地区１(),
                entity.get地区２(),
                entity.get地区３());
    }

    private RString get行政区(GyoseikuCode value) {
        RString 行政区 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            行政区 = value.value();
        }
        return 行政区;
    }

    private RString get郵便番号(YubinNo value) {
        RString 郵便番号 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            郵便番号 = value.value();
        }
        return 郵便番号;
    }

    private RString get識別コード(ShikibetsuCode value) {
        RString 識別コード = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            識別コード = value.value();
        }
        return 識別コード;
    }

    private RString get世帯コード(SetaiCode value) {
        RString 世帯コード = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            世帯コード = value.value();
        }
        return 世帯コード;
    }

    private RString get氏名(AtenaMeisho value) {
        RString 氏名 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            氏名 = value.value();
        }
        return 氏名;
    }

    private RString get氏名カナ(AtenaKanaMeisho value) {
        RString 氏名カナ = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            氏名カナ = value.value();
        }
        return 氏名カナ;
    }

    /**
     * 帳票分類ID「DBA200002_HihokenshaDaichoHakkoIchiranhyo」被保険者台帳一覧表出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("listUpper_5"), new RString("\"ShikibetsuTaisho_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"ShikibetsuTaisho_choikiCode\"")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString("番地コード"), new RString("番地コード")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("listUpper_4"), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString("chikuCode1"), new RString("\"ShikibetsuTaisho_chikuCode1\"")),
        /**
         * 地区１
         */
        地区２(new RString("0006"), new RString("chikuCode2"), new RString("\"ShikibetsuTaisho_chikuCode2\"")),
        /**
         * 地区１
         */
        地区３(new RString("0007"), new RString("chikuCode3"), new RString("\"ShikibetsuTaisho_chikuCode3\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("listLower_4"), new RString("\"ShikibetsuTaisho_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("listUpper_6"), new RString("\"dbT1001HihokenshaDaicho_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("listUpper_1"), new RString("\"ShikibetsuTaisho_kanaMeisho\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("listLower_2"), new RString("\"ShikibetsuTaisho_seinengappiYMD\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("listUpper_2"), new RString("\"ShikibetsuTaisho_seibetsuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"dbT1001HihokenshaDaicho_shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listNo_1"), new RString("\"dbT1001HihokenshaDaicho_hihokenshaNo\""));

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
