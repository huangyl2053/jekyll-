/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1150001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ShotokuKanri;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.SetaiInn;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.ShikibetsuTaishoEntity;
import jp.co.ndensan.reams.db.dbb.business.core.shotokushokaihyo.ShotokushokaihyoTaishoSetaiin;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.NushiJuminJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.dgHakkoKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.dgShotokuShokaiHyoHakko_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.dgShuseiSetaiIn_Row;
import jp.co.ndensan.reams.db.dbb.service.core.nushijuminjoho.NushiJuminJohoService;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.models.ITennyuMae;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.memo.MemoShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 所得照会票作成のハンドラクラスです。
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public final class NushiJuminJohoHandler {

    private final NushiJuminJohoDiv div;
    private static final RString 転出者 = new RString("3");
    private static final ReportId 差出人情報帳票ＩＤ = new ReportId("DBB100001_ShotokuShokaihyoDaihyo");
    private static final Code CODE_111 = new Code("111");
    private static final Code CODE_112 = new Code("112");
    private static final Code CODE_120 = new Code("120");
    private static final RString 単一市町村 = new RString("単一市町村");
    private static final RString 広域市町村 = new RString("広域市町村");
    private static final RString 管内 = new RString("管内");
    private static final RString 管外 = new RString("管外");
    private static final int 整数_ZERO = 0;
    private static final int 整数_ONE = 1;
    private static final int 整数_NINE = 9;
    private static final int 整数_TEN = 10;
    private static final int 整数_FIFTEEN = 15;
    private static final RString 文字列_ONE = new RString("1");
    private static final RString 文字列_TWO = new RString("2");
    private static final RString 文字列_THREE = new RString("3");
    private static final RString 文字列_FOUR = new RString("4");
    private static final RString 文字列_FIVE = new RString("5");
    private static final RString 表示 = new RString("表示");
    private static final RString 非表示 = new RString("非表示");
    private static final RString 区 = new RString("区");
    private static final RString 市 = new RString("市");
    private static final RString 町 = new RString("町");
    private static final RString 村 = new RString("村");
    private static final RString 役所 = new RString("役所");
    private static final RString 役場 = new RString("役場");

    private NushiJuminJohoHandler(NushiJuminJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div div
     * @return NushiJuminJohoServiceHandler
     */
    public static NushiJuminJohoHandler of(NushiJuminJohoDiv div) {
        return new NushiJuminJohoHandler(div);
    }

    /**
     * get所得照会票発行対象世帯員リストのメソッドます。
     *
     * @param 識別コード ShikibetsuCode
     * @return 所得照会票発行対象世帯員リスト
     */
    public List<ShotokushokaihyoTaishoSetaiin> get所得照会票発行対象世帯員リスト(ShikibetsuCode 識別コード) {
        List<SetaiinJoho> 世帯所得情報一覧List = SetaiinFinder.createInstance().get所得照会票用世帯員情報(識別コード);
        List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト = new ArrayList<>();
        for (SetaiinJoho entity : 世帯所得情報一覧List) {
            ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員 = new ShotokushokaihyoTaishoSetaiin();
            IShikibetsuTaisho 識別対象 = entity.get識別対象();
            所得照会票発行対象世帯員.set識別対象(識別対象);
            ZenkokuJushoCode 全国住所コード入力;
            if (!文字列_THREE.equals(識別対象.to個人().get住民状態().コード())) {
                全国住所コード入力 = 所得照会票発行対象世帯員.get識別対象().to個人().get転入前().get全国住所コード();
                if (全国住所コード入力 != null && !全国住所コード入力.isEmpty()) {
                    set送付先住所_郵便番号_住所(new LasdecCode(全国住所コード入力.getShichosonCode6()), 所得照会票発行対象世帯員);
                }
            } else {
                全国住所コード入力 = 所得照会票発行対象世帯員.get識別対象().to個人().get住登内住所().get全国住所コード();
                if (全国住所コード入力 != null && !全国住所コード入力.isEmpty()) {
                    set送付先住所_郵便番号_住所(new LasdecCode(全国住所コード入力.getShichosonCode6()), 所得照会票発行対象世帯員);
                }
            }
            所得照会票発行対象世帯員.set送付先全国住所コード(全国住所コード入力);
            所得照会票発行対象世帯員.set前住所(get住所(所得照会票発行対象世帯員));
            所得照会票発行対象世帯員.set現住所(get現住所(所得照会票発行対象世帯員));
            所得照会票発行対象世帯員リスト.add(所得照会票発行対象世帯員);
        }
        return 所得照会票発行対象世帯員リスト;
    }

    /**
     * set所得照会票個別発行個人一覧のメソッドます。
     *
     * @param 所得照会票発行対象世帯員リスト List<ShotokushokaihyoTaishoSetaiin>
     */
    public void set所得照会票個別発行個人一覧(List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト) {
        List<dgShotokuShokaiHyoHakko_Row> rowList = new ArrayList<>();
        for (ShotokushokaihyoTaishoSetaiin entity : 所得照会票発行対象世帯員リスト) {
            dgShotokuShokaiHyoHakko_Row row = new dgShotokuShokaiHyoHakko_Row();
            IShikibetsuTaisho 識別対象 = entity.get識別対象();
            if (識別対象 != null) {
                row.setTxtShikibetsuCode(識別対象.get識別コード().value());
                row.setTxtShimei(識別対象.get名称().getName().value());
                row.setTxtKetsugo01(識別対象.get名称().getName().value());
                RString 住民種別 = 識別対象.get住民種別().toRString();
                row.setTxtShubetsu(住民種別);
                RString 性別 = 識別対象.to個人().get性別().toRString();
                row.setTxtSeibetsu(性別);
                row.setTxtKetsugo02(性別);
                row.setTxtZokugara(識別対象.to個人().get続柄());
                FlexibleDate 生年月日 = 識別対象.to個人().get生年月日().toFlexibleDate();
                row.getTxtSeinenGappi().setValue(生年月日);
                row.setTxtKetsugo03(new RString(生年月日.toString()));
                RString 転入異動日 = 識別対象.to個人().get登録異動年月日().wareki().toDateString();
                row.setTxtTennyuTodokedeBi(転入異動日);
                RString 転入届出日 = 識別対象.to個人().get登録届出年月日().wareki().toDateString();
                row.setTxtTennyuTodokedeBi(転入届出日);
                ITennyuMae 転入前住所 = 識別対象.to個人().get転入前();
                if (転入前住所 != null) {
                    RString 住所 = 転入前住所.get住所();
                    RString 番地 = 転入前住所.get番地().getBanchi().value();
                    RString 方書 = 転入前住所.get方書().value();
                    row.setTxtTennyumaeJusho(住所.concat(番地).concat(RString.HALF_SPACE).concat(方書));
                    row.setTxtKetsugo04(住所.concat(番地).concat(RString.HALF_SPACE).concat(方書));
                }
                if (文字列_THREE.equals(識別対象.to個人().get住民状態().コード()) && get転出確定異動年月日(識別対象) != null) {
                    row.setTxtTenshutsubi1(get転出確定異動年月日(識別対象).wareki().toDateString());
                }
                if (文字列_THREE.equals(識別対象.to個人().get住民状態().コード()) && get転出確定異動年月日(識別対象) == null) {
                    row.setTxtTenshutsubi1(get転出予定異動年月日日(識別対象).wareki().toDateString());
                }
                if (文字列_THREE.equals(識別対象.to個人().get住民状態().コード())) {
                    RString 住所 = entity.get識別対象().get住所().get住所();
                    RString 番地 = new RString(entity.get識別対象().get住所().get番地().getBanchi().toString());
                    RString 方書 = entity.get識別対象().get住所().get方書().value();
                    row.setTxtTenshutsusakiJusho(住所.concat(RString.HALF_SPACE).concat(番地).concat(RString.HALF_SPACE).concat(方書));
                    row.setTxtKetsugo05(住所.concat(RString.HALF_SPACE).concat(番地).concat(RString.HALF_SPACE).concat(方書));
                }
                row.setTxtMemoShikibetsuTaishoCode(識別対象.get識別コード().value());
                row.setTxtMemoShikibetsuKbn(MemoShikibetsuTaisho.識別コード.get識別対象());
                rowList.add(row);
            }
        }
        div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().setDataSource(rowList);
    }

    private void set送付先住所_郵便番号_住所(LasdecCode 全国住所コード, ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員) {
        RString 役所_役場名 = RString.EMPTY;
        RString 役所_役場名の上段;
        RString 役所_役場名の下段;
        RString 住所;
        RString 住所の上段;
        RString 住所の下段;
        ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
        ShichosonAtesaki atesaki = finder.get市町村宛先(全国住所コード, SofusakiGroup.所得照会関連.getCode());
        if (atesaki != null) {
            所得照会票発行対象世帯員.set送付先郵便番号(atesaki.get郵便番号());
            RString 名称 = atesaki.get名称();
            if (!名称.isNullOrEmpty()) {
                役所_役場名 = set役所_役場名(名称, 役所_役場名, atesaki);
            }
            if (整数_TEN <= 役所_役場名.length()) {
                役所_役場名の上段 = 役所_役場名.substring(整数_ZERO, 整数_NINE);
                所得照会票発行対象世帯員.set送付先役所名１段目(役所_役場名の上段);
                役所_役場名の下段 = 役所_役場名.substring(整数_NINE, 役所_役場名.length());
                所得照会票発行対象世帯員.set送付先役所名２段目(役所_役場名の下段);
            }
            if (役所_役場名.length() <= 整数_NINE) {
                役所_役場名の上段 = RString.EMPTY;
                所得照会票発行対象世帯員.set送付先役所名１段目(役所_役場名の上段);
                役所_役場名の下段 = 役所_役場名;
                所得照会票発行対象世帯員.set送付先役所名２段目(役所_役場名の下段);
            }
            住所 = atesaki.get住所().concat(RString.FULL_SPACE).concat(atesaki.get番地().value());
            if (整数_FIFTEEN <= 住所.length()) {
                住所の上段 = 住所.substring(整数_ZERO, 整数_FIFTEEN);
                所得照会票発行対象世帯員.set送付先住所１段目(住所の上段);
                住所の下段 = 住所.substring(整数_FIFTEEN, 住所.length());
                所得照会票発行対象世帯員.set送付先住所２段目(住所の下段);
            }
            if (住所.length() <= 整数_FIFTEEN) {
                住所の上段 = RString.EMPTY;
                所得照会票発行対象世帯員.set送付先住所１段目(住所の上段);
                住所の下段 = 住所;
                所得照会票発行対象世帯員.set送付先住所２段目(住所の下段);
            }
        }
    }

    private FlexibleDate get転出確定異動年月日(IShikibetsuTaisho 識別対象) {
        return 識別対象.to個人().get転出確定().get異動年月日();
    }

    private FlexibleDate get転出予定異動年月日日(IShikibetsuTaisho 識別対象) {
        return 識別対象.to個人().get転出予定().get異動年月日();
    }

    /**
     * set世帯員の所得照会票印字内容の修正エリアのメソッドます。
     */
    public void set世帯員の所得照会票印字内容の修正エリア() {
        List<dgShotokuShokaiHyoHakko_Row> rowList = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        List<dgShuseiSetaiIn_Row> setaiIn_RowList = new ArrayList<>();
        if (rowList != null && !rowList.isEmpty()) {
            for (dgShotokuShokaiHyoHakko_Row row : rowList) {
                dgShuseiSetaiIn_Row setaiIn_Row = new dgShuseiSetaiIn_Row();
                setaiIn_Row.setTxtShikibetsuCodeShuseiYo(row.getTxtShikibetsuCode());
                setaiIn_Row.setTxtShimeiShuseiYo(row.getTxtShimei());
                setaiIn_Row.setTxtKetsugoShuseiYo(row.getTxtShimei());
                setaiIn_RowList.add(setaiIn_Row);
            }
        }
        div.getShotokuShokaihyoShuseiNyuryokuPanel().getShuseiSetaiInListPanel().getDgShuseiSetaiIn().setDataSource(setaiIn_RowList);
    }

    /**
     * set所得照会送付先のメソッドます。
     *
     * @param 所得照会票発行対象世帯員リスト List<ShotokushokaihyoTaishoSetaiin>
     */
    public void set所得照会送付先(List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト) {
        List<dgShotokuShokaiHyoHakko_Row> rowList = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        if (rowList != null && !rowList.isEmpty()) {
            int no = rowList.get(整数_ZERO).getId();
            ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員 = 所得照会票発行対象世帯員リスト.get(no);
            ZenkokuJushoCode 全国住所コード入力 = 所得照会票発行対象世帯員.get送付先全国住所コード();
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getCcdZenkokuJushoInput1().load(全国住所コード入力);
            RString 役所_役場名 = RString.EMPTY;
            RString 役所_役場名の上段 = RString.EMPTY;
            RString 役所_役場名の下段 = RString.EMPTY;
            RString 住所の上段 = RString.EMPTY;
            RString 住所の下段 = RString.EMPTY;
            ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
            LasdecCode 全国住所コード = LasdecCode.EMPTY;
            if (!div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().
                    getSofusakiNyuryokuPanel().getCcdZenkokuJushoInput1().get全国住所コード().isEmpty()) {
                全国住所コード = new LasdecCode(div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().
                        getSofusakiNyuryokuPanel().getCcdZenkokuJushoInput1().get全国住所コード().getShichosonCode6());
            }
            ShichosonAtesaki atesaki = finder.get市町村宛先(全国住所コード, SofusakiGroup.所得照会関連.getCode());
            set所得照会送付先(atesaki, 役所_役場名, 役所_役場名の上段, 役所_役場名の下段, 住所の上段, 住所の下段, 所得照会票発行対象世帯員);
        }
    }

    private void set所得照会送付先(ShichosonAtesaki atesaki, RString 役所_役場名, RString 役所_役場名の上段, RString 役所_役場名の下段,
            RString 住所の上段, RString 住所の下段, ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員) {
        RString 住所;
        if (atesaki != null) {
            RString 名称 = atesaki.get名称();
            if (!名称.isNullOrEmpty()) {
                役所_役場名 = set役所_役場名(名称, 役所_役場名, atesaki);
            }
            if (整数_TEN <= 役所_役場名.length()) {
                役所_役場名の上段 = 役所_役場名.substring(整数_ZERO, 整数_NINE);
                役所_役場名の下段 = 役所_役場名.substring(整数_NINE, 役所_役場名.length());
            }
            if (役所_役場名.length() <= 整数_NINE) {
                役所_役場名の下段 = 役所_役場名;
            }
            住所 = atesaki.get住所().concat(RString.FULL_SPACE).concat(atesaki.get番地().value());
            if (整数_FIFTEEN <= 住所.length()) {
                住所の上段 = 住所.substring(整数_ZERO, 整数_FIFTEEN);
                住所の下段 = 住所.substring(整数_FIFTEEN, 住所.length());
            }
            if (住所.length() <= 整数_FIFTEEN) {
                住所の下段 = 住所;
            }
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusakiYubinNo().setValue(atesaki.get郵便番号());
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusaki01().setValue(住所の上段);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusaki02().setValue(住所の下段);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusaki03().setValue(役所_役場名の上段);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusakiOnchu().setValue(役所_役場名の下段);
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesakiManager().get介護問合せ先(SubGyomuCode.DBB介護賦課, 差出人情報帳票ＩＤ);
            RString 担当課名 = 介護問合せ先.get部署名();
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                    .getSofusakiNyuryokuPanel().getTxtSofusakiSama().setValue(担当課名);
            RString 前住所 = get住所(所得照会票発行対象世帯員);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                    .getGenJushoNyuryokuPanel().getTxtZenJusho().setValue(前住所);
            RString 現住所 = get現住所(所得照会票発行対象世帯員);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                    .getGenJushoPanel().getTxtGenJusho().setValue(現住所);

        }
    }

    /**
     * get住所のメソッドます。
     *
     * @param 所得照会票発行対象世帯員 ShotokushokaihyoTaishoSetaiin
     * @return 住所
     */
    public RString get住所(ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員) {
        RString 単一市町村と広域市町村モード = RString.EMPTY;
        boolean 転出者フラグ = false;
        RString 管内管外区分 = RString.EMPTY;
        RString 前住所 = RString.EMPTY;
        RString 前住所_管内_管外区分 = RString.EMPTY;
        RString 前住所_住所 = RString.EMPTY;
        RString 前住所_番地 = RString.EMPTY;
        RString 前住所_方書 = RString.EMPTY;
        RString 前住所_行政区 = RString.EMPTY;
        RString 前住所_住所編集方法 = RString.EMPTY;
        RString 前住所_都道府県表示有無 = RString.EMPTY;
        RString 前住所_市町村名表示有無 = RString.EMPTY;
        RString 前住所_方書表示有無 = RString.EMPTY;
        RString 前住所_都道府県名称 = RString.EMPTY;
        RString 前住所_市町村名称 = RString.EMPTY;
        RString 転入前住所_住所 = RString.EMPTY;
        RString 転入前住所_番地 = RString.EMPTY;
        RString 転入前住所_方書 = RString.EMPTY;
        ITennyuMae 転入前住所 = 所得照会票発行対象世帯員.get識別対象().to個人().get転入前();
        if (転入前住所 != null) {
            転入前住所_住所 = 転入前住所.get住所();
            転入前住所_番地 = 転入前住所.get番地().getBanchi().value();
            転入前住所_方書 = 転入前住所.get方書().value();
        }
        単一市町村と広域市町村モード = set単一市町村と広域市町村モード(単一市町村と広域市町村モード);
        転出者フラグ = set転出者フラグ(所得照会票発行対象世帯員, 転出者フラグ);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.set識別コード(所得照会票発行対象世帯員.get識別対象().get識別コード());
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        ShikibetsuTaishoEntity 宛名識別対象ＰＳＭ = NushiJuminJohoService.createInstance().get宛名識別対象(searchKey);
        if (文字列_ONE.equals(宛名識別対象ＰＳＭ.get宛名PSM().getKannaiKangaiKubun())) {
            管内管外区分 = 管内;
        }
        if (文字列_TWO.equals(宛名識別対象ＰＳＭ.get宛名PSM().getKannaiKangaiKubun())) {
            管内管外区分 = 管外;
        }
        SearchResult<KoikiZenShichosonJoho> 単一市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho();
        SearchResult<ShichosonCodeYoriShichoson> 広域市町村情報 = KoikiShichosonJohoFinder.createInstance()
                .shichosonCodeYoriShichosonJoho(宛名識別対象ＰＳＭ.get宛名PSM().getGenLasdecCode());

        if (!転出者フラグ) {
            前住所_管内_管外区分 = 管内管外区分;
            前住所_住所 = 転入前住所_住所;
            前住所_番地 = 転入前住所_番地;
            前住所_方書 = 転入前住所_方書;
            前住所_住所編集方法 = 文字列_ONE;
            前住所_都道府県表示有無 = 非表示;
            前住所_市町村名表示有無 = 非表示;
            前住所_方書表示有無 = 表示;
        }
        if (転出者フラグ && 単一市町村.equals(単一市町村と広域市町村モード)) {
            前住所_管内_管外区分 = 管内;
            前住所_住所 = 宛名識別対象ＰＳＭ.get宛名PSM().getJutonaiJusho();
            AtenaBanchi 番地 = 宛名識別対象ＰＳＭ.get宛名PSM().getJutonaiBanchi();
            前住所_番地 = set現住所_番地(番地, 前住所_番地);
            Katagaki 方書 = 宛名識別対象ＰＳＭ.get宛名PSM().getJutonaiKatagaki();
            前住所_方書 = set現住所_方書(方書, 前住所_方書);
            前住所_住所編集方法 = 文字列_ONE;
            前住所_都道府県表示有無 = 表示;
            前住所_市町村名表示有無 = 表示;
            前住所_方書表示有無 = 表示;
            前住所_都道府県名称 = 単一市町村情報.records().get(整数_ZERO).get都道府県名称();
            前住所_市町村名称 = 単一市町村情報.records().get(整数_ZERO).get市町村名称();
        }
        if (転出者フラグ && 広域市町村.equals(単一市町村と広域市町村モード)) {
            前住所_管内_管外区分 = 管内;
            前住所_住所 = 宛名識別対象ＰＳＭ.get宛名PSM().getJutonaiJusho();
            AtenaBanchi 番地 = 宛名識別対象ＰＳＭ.get宛名PSM().getJutonaiBanchi();
            前住所_番地 = set現住所_番地(番地, 前住所_番地);
            Katagaki 方書 = 宛名識別対象ＰＳＭ.get宛名PSM().getJutonaiKatagaki();
            前住所_方書 = set現住所_方書(方書, 前住所_方書);
            前住所_住所編集方法 = 文字列_ONE;
            前住所_都道府県表示有無 = 表示;
            前住所_市町村名表示有無 = 非表示;
            前住所_方書表示有無 = 表示;
            前住所_都道府県名称 = 広域市町村情報.records().get(整数_ZERO).get都道府県名称();
        }
        前住所 = set現住所(前住所_管内_管外区分, 前住所_都道府県表示有無, 前住所, 前住所_都道府県名称, 前住所_市町村名表示有無, 前住所_市町村名称,
                前住所_住所編集方法, 前住所_住所, 前住所_番地, 前住所_行政区);
        if (管外.equals(前住所_管内_管外区分)) {
            前住所 = 前住所.concat(前住所_住所).concat(前住所_番地);
        }
        if (表示.equals(前住所_方書表示有無) && 文字列_FIVE.equals(前住所_住所編集方法)) {
            前住所 = 前住所.concat(RString.HALF_SPACE).concat(前住所_方書);
        }
        return 前住所;
    }

    private boolean set転出者フラグ(ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員, boolean 転出者フラグ) {
        if (転出者.equals(所得照会票発行対象世帯員.get識別対象().get住民種別().getCode())) {
            転出者フラグ = true;
        }
        return 転出者フラグ;
    }

    /**
     * get現住所のメソッドます。
     *
     * @param 所得照会票発行対象世帯員 ShotokushokaihyoTaishoSetaiin
     * @return RString
     */
    public RString get現住所(ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員) {
        RString 単一市町村と広域市町村モード = RString.EMPTY;
        boolean 転出者フラグ = false;
        RString 管内管外区分 = RString.EMPTY;
        RString 現住所 = RString.EMPTY;
        RString 現住所_管内_管外区分 = RString.EMPTY;
        RString 現住所_住所 = RString.EMPTY;
        RString 現住所_番地 = RString.EMPTY;
        RString 現住所_方書 = RString.EMPTY;
        RString 現住所_行政区 = RString.EMPTY;
        RString 現住所_住所編集方法 = RString.EMPTY;
        RString 現住所_都道府県表示有無 = RString.EMPTY;
        RString 現住所_市町村名表示有無 = RString.EMPTY;
        RString 現住所_方書表示有無 = RString.EMPTY;
        RString 現住所_都道府県名称 = RString.EMPTY;
        RString 現住所_市町村名称 = RString.EMPTY;
        RString 転出先住所_住所 = RString.EMPTY;
        RString 転出先住所_番地 = RString.EMPTY;
        RString 転出先住所_方書 = RString.EMPTY;
        IJusho 転入前住所 = 所得照会票発行対象世帯員.get識別対象().get住所();
        if (転入前住所 != null) {
            転出先住所_住所 = 転入前住所.get住所();
            転出先住所_番地 = 転入前住所.get番地().getBanchi().value();
            転出先住所_方書 = 転入前住所.get方書().value();
        }
        単一市町村と広域市町村モード = set単一市町村と広域市町村モード(単一市町村と広域市町村モード);
        転出者フラグ = set転出者フラグ(所得照会票発行対象世帯員, 転出者フラグ);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.set識別コード(所得照会票発行対象世帯員.get識別対象().get識別コード());
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        ShikibetsuTaishoEntity 宛名識別対象ＰＳＭ = NushiJuminJohoService.createInstance().get宛名識別対象(searchKey);
        if (文字列_ONE.equals(宛名識別対象ＰＳＭ.get宛名PSM().getKannaiKangaiKubun())) {
            管内管外区分 = 管内;
        }
        if (文字列_TWO.equals(宛名識別対象ＰＳＭ.get宛名PSM().getKannaiKangaiKubun())) {
            管内管外区分 = 管外;
        }
        SearchResult<KoikiZenShichosonJoho> 単一市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho();
        SearchResult<ShichosonCodeYoriShichoson> 広域市町村情報 = KoikiShichosonJohoFinder.createInstance()
                .shichosonCodeYoriShichosonJoho(宛名識別対象ＰＳＭ.get宛名PSM().getGenLasdecCode());
        if (!転出者フラグ && 単一市町村.equals(単一市町村と広域市町村モード)) {
            現住所_管内_管外区分 = 管内管外区分;
            現住所_住所 = 転出先住所_住所;
            現住所_番地 = 転出先住所_番地;
            現住所_方書 = 転出先住所_方書;
            現住所_住所編集方法 = 文字列_ONE;
            現住所_都道府県表示有無 = 表示;
            現住所_市町村名表示有無 = 表示;
            現住所_方書表示有無 = 表示;
            現住所_都道府県名称 = 単一市町村情報.records().get(整数_ZERO).get都道府県名称();
            現住所_市町村名称 = 単一市町村情報.records().get(整数_ZERO).get市町村名称();
        }
        if (!転出者フラグ && 広域市町村.equals(単一市町村と広域市町村モード)) {
            現住所_管内_管外区分 = 管内管外区分;
            現住所_住所 = 転出先住所_住所;
            現住所_番地 = 転出先住所_番地;
            現住所_方書 = 転出先住所_方書;
            現住所_住所編集方法 = 文字列_ONE;
            現住所_都道府県表示有無 = 表示;
            現住所_市町村名表示有無 = 非表示;
            現住所_方書表示有無 = 表示;
            現住所_都道府県名称 = 広域市町村情報.records().get(整数_ZERO).get都道府県名称();
        }
        if (転出者フラグ && 管内.equals(管内管外区分) && 単一市町村.equals(単一市町村と広域市町村モード)) {
            現住所_管内_管外区分 = 管内管外区分;
            AtenaJusho 住所 = 宛名識別対象ＰＳＭ.get宛名PSM().getJusho();
            現住所_住所 = set現住所_住所(住所, 現住所_住所);
            AtenaBanchi 番地 = 宛名識別対象ＰＳＭ.get宛名PSM().getBanchi();
            現住所_番地 = set現住所_番地(番地, 現住所_番地);
            Katagaki 方書 = 宛名識別対象ＰＳＭ.get宛名PSM().getKatagaki();
            現住所_方書 = set現住所_方書(方書, 現住所_方書);
            現住所_住所編集方法 = 文字列_ONE;
            現住所_都道府県表示有無 = 表示;
            現住所_市町村名表示有無 = 表示;
            現住所_方書表示有無 = 表示;
            現住所_都道府県名称 = 単一市町村情報.records().get(整数_ZERO).get都道府県名称();
            現住所_市町村名称 = 単一市町村情報.records().get(整数_ZERO).get市町村名称();
        }
        if (転出者フラグ && 管内.equals(管内管外区分) && 広域市町村.equals(単一市町村と広域市町村モード)) {
            現住所_管内_管外区分 = 管内管外区分;
            AtenaJusho 住所 = 宛名識別対象ＰＳＭ.get宛名PSM().getJusho();
            現住所_住所 = set現住所_住所(住所, 現住所_住所);
            AtenaBanchi 番地 = 宛名識別対象ＰＳＭ.get宛名PSM().getBanchi();
            現住所_番地 = set現住所_番地(番地, 現住所_番地);
            Katagaki 方書 = 宛名識別対象ＰＳＭ.get宛名PSM().getKatagaki();
            現住所_方書 = set現住所_方書(方書, 現住所_方書);
            現住所_住所編集方法 = 文字列_ONE;
            現住所_都道府県表示有無 = 表示;
            現住所_市町村名表示有無 = 非表示;
            現住所_方書表示有無 = 表示;
            現住所_都道府県名称 = 広域市町村情報.records().get(整数_ZERO).get都道府県名称();
        }
        if (転出者フラグ && 管外.equals(管内管外区分)) {
            現住所_管内_管外区分 = 管内管外区分;
            AtenaJusho 住所 = 宛名識別対象ＰＳＭ.get宛名PSM().getJusho();
            現住所_住所 = set現住所_住所(住所, 現住所_住所);
            AtenaBanchi 番地 = 宛名識別対象ＰＳＭ.get宛名PSM().getBanchi();
            現住所_番地 = set現住所_番地(番地, 現住所_番地);
            Katagaki 方書 = 宛名識別対象ＰＳＭ.get宛名PSM().getKatagaki();
            現住所_方書 = set現住所_方書(方書, 現住所_方書);
            現住所_住所編集方法 = 文字列_ONE;
            現住所_都道府県表示有無 = 非表示;
            現住所_市町村名表示有無 = 非表示;
            現住所_方書表示有無 = 表示;
        }
        現住所 = set現住所(現住所_管内_管外区分, 現住所_都道府県表示有無, 現住所, 現住所_都道府県名称, 現住所_市町村名表示有無, 現住所_市町村名称,
                現住所_住所編集方法, 現住所_住所, 現住所_番地, 現住所_行政区);
        if (管外.equals(現住所_管内_管外区分)) {
            現住所 = 現住所.concat(現住所_住所).concat(現住所_番地);
        }
        if (表示.equals(現住所_方書表示有無) && 文字列_FIVE.equals(現住所_住所編集方法)) {
            現住所 = 現住所.concat(RString.HALF_SPACE).concat(現住所_方書);
        }
        return 現住所;

    }

    private RString set現住所_方書(Katagaki 方書, RString 現住所_方書) {
        if (方書 != null) {
            現住所_方書 = 方書.value();
        }
        return 現住所_方書;
    }

    private RString set現住所_番地(AtenaBanchi 番地, RString 現住所_番地) {
        if (番地 != null) {
            現住所_番地 = 番地.value();
        }
        return 現住所_番地;
    }

    private RString set現住所_住所(AtenaJusho 住所, RString 現住所_住所) {
        if (住所 != null) {
            現住所_住所 = 住所.value();
        }
        return 現住所_住所;
    }

    private RString set現住所(RString 現住所_管内_管外区分, RString 現住所_都道府県表示有無, RString 現住所, RString 現住所_都道府県名称,
            RString 現住所_市町村名表示有無, RString 現住所_市町村名称, RString 現住所_住所編集方法, RString 現住所_住所,
            RString 現住所_番地, RString 現住所_行政区) {
        if (管内.equals(現住所_管内_管外区分)) {
            if (表示.equals(現住所_都道府県表示有無)) {
                現住所 = 現住所.concat(現住所_都道府県名称);
            }
            if (表示.equals(現住所_市町村名表示有無)) {
                現住所 = 現住所.concat(現住所_市町村名称);
            }
            if (文字列_ONE.equals(現住所_住所編集方法)) {
                現住所 = 現住所.concat(現住所_住所).concat(現住所_番地);
            }
            if (文字列_TWO.equals(現住所_住所編集方法)) {
                現住所 = 現住所.concat(現住所_行政区).concat(現住所_番地);
            }
            if (文字列_THREE.equals(現住所_住所編集方法)) {
                現住所 = 現住所.concat(現住所_住所).concat(現住所_番地).concat(現住所_行政区);
            }
            if (文字列_FOUR.equals(現住所_住所編集方法)) {
                現住所 = 現住所.concat(現住所_番地);
            }
            if (文字列_FIVE.equals(現住所_住所編集方法)) {
                現住所 = RString.EMPTY;
            }

        }
        return 現住所;
    }

    private RString set単一市町村と広域市町村モード(RString 単一市町村と広域市町村モード) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (CODE_112.equals(市町村セキュリティ情報.get導入形態コード()) || CODE_120.equals(市町村セキュリティ情報.get導入形態コード())) {
            単一市町村と広域市町村モード = 単一市町村;
        }
        if (CODE_111.equals(市町村セキュリティ情報.get導入形態コード())) {
            単一市町村と広域市町村モード = 広域市町村;
        }
        return 単一市町村と広域市町村モード;
    }

    /**
     * set所得照会票の発行のメソッドます。
     *
     * @param 所得照会票発行対象世帯員リスト List<ShotokushokaihyoTaishoSetaiin>
     */
    public void set所得照会票の発行(List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト) {
        KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesakiManager().get介護問合せ先(SubGyomuCode.DBB介護賦課, 差出人情報帳票ＩＤ);
        if (介護問合せ先 != null) {
            div.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtSashidashiNinYubinNo().setValue(介護問合せ先.get郵便番号());
            RString 住所 = 介護問合せ先.get所在地().concat(介護問合せ先.get庁舎名());
            div.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtSashidashiNinJusho().setValue(住所);
            div.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtSashidashiNinTanto().setValue(介護問合せ先.get部署名());
            div.getHakkoKakuninPanel().getSashidashininKakuninPanel().getTxtSashidashiNinTellNo().setDomain(介護問合せ先.get電話番号());
        }
        List<dgHakkoKakunin_Row> rowList = new ArrayList<>();
        List<dgShotokuShokaiHyoHakko_Row> hyoHakkoRowList = div.getShotokuShokaiHyoHakkoIchiranPanel()
                .getDgShotokuShokaiHyoHakko().getSelectedItems();
        ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
        for (dgShotokuShokaiHyoHakko_Row hyoHakkoRow : hyoHakkoRowList) {
            dgHakkoKakunin_Row row = new dgHakkoKakunin_Row();
            int no = hyoHakkoRow.getId();
            ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員 = 所得照会票発行対象世帯員リスト.get(no);
            ZenkokuJushoCode 全国住所コード = 所得照会票発行対象世帯員.get送付先全国住所コード();
            if (全国住所コード != null && !全国住所コード.isEmpty()) {
                ShichosonAtesaki atesaki = finder.get市町村宛先(new LasdecCode(全国住所コード.getShichosonCode6()),
                        SofusakiGroup.所得照会関連.getCode());
                RString 住所 = atesaki.get住所().concat(RString.FULL_SPACE).concat(atesaki.get番地().value());
                row.setTxtSofusaki(住所);
            }
            row.setTxtTennyuuOrTenshutsu(所得照会票発行対象世帯員.get前住所());
            row.setTxtGenJusho(所得照会票発行対象世帯員.get現住所());
            row.setTxtSetaiin(hyoHakkoRow.getTxtShimei());
            rowList.add(row);
        }
        div.getHakkoKakuninPanel().getDgHakkoKakunin().setDataSource(rowList);
    }

    /**
     * get所得照会票モデルを作成のメソッドます。
     *
     * @param 所得照会票発行対象世帯員リスト List<ShotokushokaihyoTaishoSetaiin>
     * @return 所得照会票モデル
     */
    public NushiJuminJohoResult get所得照会票モデルを作成(List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト) {
        List<dgShotokuShokaiHyoHakko_Row> rowList = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        NushiJuminJohoResult 所得照会票 = new NushiJuminJohoResult();
        所得照会票.set住民税課税年度(new FlexibleYear(div.getShotokuShokaiHyoHakkoIchiranPanel().getDdlJuminzeiNendo().getSelectedKey()));
        所得照会票.set発行日(div.getShotokuShokaiHyoHakkoIchiranPanel().getTxtHakkoNengappi().getValue());
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.set識別コード(new ShikibetsuCode(rowList.get(整数_ZERO).getTxtShikibetsuCode()));
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        ShikibetsuTaishoEntity 宛名識別対象ＰＳＭ = NushiJuminJohoService.createInstance().get宛名識別対象(searchKey);
        SearchResult<KoikiZenShichosonJoho> 単一市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho();
        SearchResult<ShichosonCodeYoriShichoson> 広域市町村情報 = KoikiShichosonJohoFinder.createInstance()
                .shichosonCodeYoriShichosonJoho(宛名識別対象ＰＳＭ.get宛名PSM().getGenLasdecCode());
        if (CODE_112.equals(市町村セキュリティ情報.get導入形態コード()) || CODE_120.equals(市町村セキュリティ情報.get導入形態コード())) {
            所得照会票.set市町村名(単一市町村情報.records().get(整数_ZERO).get市町村名称());
        }
        if (CODE_111.equals(市町村セキュリティ情報.get導入形態コード())) {
            所得照会票.set市町村名(広域市町村情報.records().get(整数_ZERO).get市町村名称());
        }
        int no = rowList.get(整数_ZERO).getId();
        ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員 = 所得照会票発行対象世帯員リスト.get(no);
        所得照会票.set郵便番号(所得照会票発行対象世帯員.get送付先郵便番号());
        所得照会票.set住所_上段(所得照会票発行対象世帯員.get送付先住所１段目());
        所得照会票.set住所_下段(所得照会票発行対象世帯員.get送付先住所２段目());
        所得照会票.set役所_役場名_上段(所得照会票発行対象世帯員.get送付先役所名１段目());
        所得照会票.set役所_役場名_下段(所得照会票発行対象世帯員.get送付先役所名２段目());
        所得照会票.set生年月日(所得照会票発行対象世帯員.get識別対象().to個人().get生年月日().toFlexibleDate());
        ITennyuMae 転入前住所 = 所得照会票発行対象世帯員.get識別対象().to個人().get転入前();
        if (転入前住所 != null) {
            RString 住所 = 転入前住所.get住所();
            RString 番地 = 転入前住所.get番地().getBanchi().value();
            RString 方書 = 転入前住所.get方書().value();
            所得照会票.set転入前住所(住所.concat(番地).concat(RString.HALF_SPACE).concat(方書));
        }
        RString 住所 = 所得照会票発行対象世帯員.get識別対象().get住所().get住所();
        RString 番地 = new RString(所得照会票発行対象世帯員.get識別対象().get住所().get番地().getBanchi().toString());
        RString 方書 = 所得照会票発行対象世帯員.get識別対象().get住所().get方書().value();
        所得照会票.set転出先住所(住所.concat(RString.HALF_SPACE).concat(番地).concat(RString.HALF_SPACE).concat(方書));
        所得照会票.set氏名(所得照会票発行対象世帯員.get識別対象().get名称().getName().value());
        所得照会票.set世帯コード(所得照会票発行対象世帯員.get識別対象().to個人().get世帯コード());
        所得照会票.set前住所(所得照会票発行対象世帯員.get前住所());
        所得照会票.set現住所(所得照会票発行対象世帯員.get現住所());
        所得照会票.set住民状態コード(所得照会票発行対象世帯員.get識別対象().to個人().get住民状態().コード());
        所得照会票.set住民種別コード(所得照会票発行対象世帯員.get識別対象().get住民種別().getCode());
        List<SetaiInn> 世帯員リスト = new ArrayList<>();
        for (dgShotokuShokaiHyoHakko_Row row : rowList) {
            int rowId = row.getId();
            ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員_row = 所得照会票発行対象世帯員リスト.get(rowId);
            SetaiInn 世帯員 = new SetaiInn();
            世帯員.set住民状態コード(所得照会票発行対象世帯員_row.get識別対象().to個人().get住民状態().コード());
            世帯員.set住民種別コード(所得照会票発行対象世帯員_row.get識別対象().get住民種別().getCode());
            if (文字列_THREE.equals(所得照会票発行対象世帯員_row.get識別対象().to個人().get住民状態().コード())
                    && get転出確定異動年月日(所得照会票発行対象世帯員_row.get識別対象()) != null) {
                世帯員.set転出日(get転出確定異動年月日(所得照会票発行対象世帯員_row.get識別対象()));
            }
            if (文字列_THREE.equals(所得照会票発行対象世帯員_row.get識別対象().to個人().get住民状態().コード())
                    && get転出確定異動年月日(所得照会票発行対象世帯員_row.get識別対象()) == null) {
                世帯員.set転出日(get転出予定異動年月日日(所得照会票発行対象世帯員_row.get識別対象()));
            }
            世帯員.set転入異動日(所得照会票発行対象世帯員_row.get識別対象().to個人().get登録異動年月日());
            世帯員.set識別コード(所得照会票発行対象世帯員_row.get識別対象().get識別コード());
            世帯員.setカナ氏名(所得照会票発行対象世帯員_row.get識別対象().get名称().getKana().value());
            世帯員.set氏名(所得照会票発行対象世帯員_row.get識別対象().get名称().getName().value());
            世帯員.set生年月日(所得照会票発行対象世帯員_row.get識別対象().to個人().get生年月日().toFlexibleDate());
            世帯員リスト.add(世帯員);
        }
        所得照会票.set世帯員リスト(世帯員リスト);
        KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesakiManager().get介護問合せ先(SubGyomuCode.DBB介護賦課, 差出人情報帳票ＩＤ);
        所得照会票.set担当部署名(介護問合せ先.get部署名());
        所得照会票.set担当者名(介護問合せ先.get担当者名());
        所得照会票.set庁舎名(介護問合せ先.get庁舎名());
        所得照会票.set所在地(介護問合せ先.get所在地());
        所得照会票.set内線番号(介護問合せ先.get内線番号());
        所得照会票.set差出人_郵便番号(介護問合せ先.get郵便番号());
        所得照会票.set電話番号(介護問合せ先.get電話番号());
        return 所得照会票;
    }

    /**
     * 所得照会送付先エリアの全国住所コードの変更のメソッドます。
     */
    public void onChange_全国住所コード() {
        RString 役所_役場名 = RString.EMPTY;
        RString 役所_役場名の上段 = RString.EMPTY;
        RString 役所_役場名の下段 = RString.EMPTY;
        RString 住所;
        RString 住所の上段 = RString.EMPTY;
        RString 住所の下段 = RString.EMPTY;
        ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
        LasdecCode 全国住所コード = LasdecCode.EMPTY;
        if (!div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().
                getSofusakiNyuryokuPanel().getCcdZenkokuJushoInput1().get全国住所コード().isEmpty()) {
            全国住所コード = new LasdecCode(div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().
                    getSofusakiNyuryokuPanel().getCcdZenkokuJushoInput1().get全国住所コード().getShichosonCode6());
        }
        ShichosonAtesaki atesaki = finder.get市町村宛先(全国住所コード, SofusakiGroup.所得照会関連.getCode());
        if (atesaki != null) {
            RString 名称 = atesaki.get名称();
            if (!名称.isNullOrEmpty()) {
                役所_役場名 = set役所_役場名(名称, 役所_役場名, atesaki);
            }
            if (整数_TEN <= 役所_役場名.length()) {
                役所_役場名の上段 = 役所_役場名.substring(整数_ZERO, 整数_NINE);
                役所_役場名の下段 = 役所_役場名.substring(整数_NINE, 役所_役場名.length());
            }
            if (役所_役場名.length() <= 整数_NINE) {
                役所_役場名の下段 = 役所_役場名;
            }
            住所 = atesaki.get住所().concat(RString.FULL_SPACE).concat(atesaki.get番地().value());
            if (整数_FIFTEEN <= 住所.length()) {
                住所の上段 = 住所.substring(整数_ZERO, 整数_FIFTEEN);
                住所の下段 = 住所.substring(整数_FIFTEEN, 住所.length());
            }
            if (住所.length() <= 整数_FIFTEEN) {
                住所の下段 = 住所;
            }
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusakiYubinNo().setValue(atesaki.get郵便番号());
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusaki01().setValue(住所の上段);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusaki02().setValue(住所の下段);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusaki03().setValue(役所_役場名の上段);
            div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                    .getTxtSofusakiOnchu().setValue(役所_役場名の下段);
        }
    }

    private RString set役所_役場名(RString 名称, RString 役所_役場名, ShichosonAtesaki atesaki) {
        if (区.equals(名称.substring(名称.length() - 整数_ONE, 名称.length()))
                || 市.equals(名称.substring(名称.length() - 整数_ONE, 名称.length()))) {
            役所_役場名 = atesaki.get方書().value().concat(役所);
        }
        if (町.equals(名称.substring(名称.length() - 整数_ONE, 名称.length()))
                || 村.equals(名称.substring(名称.length() - 整数_ONE, 名称.length()))) {
            役所_役場名 = atesaki.get方書().value().concat(役場);
        }
        return 役所_役場名;
    }

    /**
     * save所得照会票発行対象世帯員のメソッドます。
     *
     * @param 所得照会票発行対象世帯員リスト List<ShotokushokaihyoTaishoSetaiin>
     * @return 所得照会票発行対象世帯員
     */
    public List<ShotokushokaihyoTaishoSetaiin> save所得照会票発行対象世帯員(List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト) {
        RString flag = 文字列_ONE;
        YubinNo 郵便番号 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                .getTxtSofusakiYubinNo().getValue();
        RString 住所の上段 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                .getTxtSofusaki01().getValue();
        RString 住所の下段 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                .getTxtSofusaki02().getValue();
        RString 役所_役場名の上段 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                .getTxtSofusaki03().getValue();
        RString 役所_役場名の下段 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel()
                .getTxtSofusakiOnchu().getValue();
        RString 前住所 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                .getGenJushoNyuryokuPanel().getTxtZenJusho().getValue();
        RString 現住所 = div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel()
                .getGenJushoPanel().getTxtGenJusho().getValue();
        List<dgShotokuShokaiHyoHakko_Row> rowList = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getDataSource();
        for (dgShotokuShokaiHyoHakko_Row row : rowList) {
            if (!前住所.equals(row.getTxtTennyumaeJusho())) {
                flag = 文字列_TWO;
            }
            row.setTxtTennyumaeJusho(前住所);
            row.setTxtKetsugo04(前住所);
            if (!現住所.equals(row.getTxtTenshutsusakiJusho())) {
                flag = 文字列_TWO;
            }
            row.setTxtTenshutsusakiJusho(現住所);
            row.setTxtKetsugo05(現住所);
        }
        div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().setDataSource(rowList);
        for (ShotokushokaihyoTaishoSetaiin 所得照会票発行対象世帯員 : 所得照会票発行対象世帯員リスト) {
            if (!郵便番号.equals(所得照会票発行対象世帯員.get送付先郵便番号())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set送付先郵便番号(郵便番号);
            if (!住所の上段.equals(所得照会票発行対象世帯員.get送付先住所１段目())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set送付先住所１段目(住所の上段);
            if (!住所の下段.equals(所得照会票発行対象世帯員.get送付先住所２段目())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set送付先住所２段目(住所の下段);
            if (!役所_役場名の上段.equals(所得照会票発行対象世帯員.get送付先役所名１段目())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set送付先役所名１段目(役所_役場名の上段);
            if (!役所_役場名の下段.equals(所得照会票発行対象世帯員.get送付先役所名２段目())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set送付先役所名２段目(役所_役場名の下段);
            if (!前住所.equals(所得照会票発行対象世帯員.get前住所())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set前住所(前住所);
            if (!現住所.equals(所得照会票発行対象世帯員.get現住所())) {
                flag = 文字列_TWO;
            }
            所得照会票発行対象世帯員.set現住所(現住所);
        }
        div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().getSofusakiNyuryokuPanel().getTextNo().setValue(flag);
        return 所得照会票発行対象世帯員リスト;
    }

    /**
     * 識別コードを取得のメソッドます。
     *
     * @return List<DbT2008ShotokuKanriEntity>
     */
    public List<ShotokuKanri> get識別コード() {
        FlexibleYear 所得年度 = new FlexibleYear(div.getShotokuShokaiHyoHakkoIchiranPanel().getDdlJuminzeiNendo().getSelectedKey());
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        List<dgShotokuShokaiHyoHakko_Row> 世帯員一覧 = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        for (dgShotokuShokaiHyoHakko_Row row : 世帯員一覧) {
            ShikibetsuCode 識別コード = new ShikibetsuCode(row.getTxtShikibetsuCode());
            識別コードList.add(識別コード);
        }
        List<ShotokuKanri> entityList = NushiJuminJohoService.createInstance().get識別コード(所得年度, 識別コードList);
        return entityList;
    }

    /**
     * db出力のメソッドます。
     *
     * @param 所得照会票発行対象世帯員リスト List<ShotokushokaihyoTaishoSetaiin>
     */
    public void db出力(List<ShotokushokaihyoTaishoSetaiin> 所得照会票発行対象世帯員リスト) {
        FlexibleYear 所得年度 = new FlexibleYear(div.getShotokuShokaiHyoHakkoIchiranPanel().getDdlJuminzeiNendo().getSelectedKey());
        FlexibleDate 発行日 = new FlexibleDate(div.getShotokuShokaiHyoHakkoIchiranPanel().getTxtHakkoNengappi().getValue().toDateString());
        LasdecCode 全国住所コード = LasdecCode.EMPTY;
        if (!div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().
                getSofusakiNyuryokuPanel().getCcdZenkokuJushoInput1().get全国住所コード().isEmpty()) {
            全国住所コード = new LasdecCode(div.getShotokuShokaihyoShuseiNyuryokuPanel().getSofusakiGenJushoShuseiPanel().
                    getSofusakiNyuryokuPanel().getCcdZenkokuJushoInput1().get全国住所コード().getShichosonCode6());
        }
        List<dgShotokuShokaiHyoHakko_Row> 世帯員一覧 = div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko().getSelectedItems();
        for (dgShotokuShokaiHyoHakko_Row row : 世帯員一覧) {
            ShikibetsuCode 識別コード = new ShikibetsuCode(row.getTxtShikibetsuCode());
            int no = row.getId();
            SetaiCode 世帯コード = 所得照会票発行対象世帯員リスト.get(no).get識別対象().to個人().get世帯コード();
            NushiJuminJohoService.createInstance().db出力(所得年度, 識別コード, 全国住所コード, 世帯コード, 発行日);
        }
    }
}
