/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaitaishosha.ShinsakaiTaishoshaBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.ShinsakaiTaishoshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0120001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 審査会個人別状況照会のハンドラークラスです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
public class ShinsakaiTaishoshaHandler {

    private final ShinsakaiTaishoshaDiv div;
    private static final Code SHIKI = new Code("0001");
    private static final RString 管理番号 = new RString("申請書管理番号");
    private static final RString CODESHUBETSU_5001 = new RString("5001");

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiTaishoshaDiv
     */
    public ShinsakaiTaishoshaHandler(ShinsakaiTaishoshaDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化に画面項目の値を表示します。
     *
     * @param 予定情報 予定情報と結果情報
     * @param 一覧情報 List<ShinsakaiTaishoshaBusiness>
     */
    public void onLoad(ShinsakaiTaishoshaBusiness 予定情報, List<ShinsakaiTaishoshaBusiness> 一覧情報) {
        RStringBuilder 開催番号 = new RStringBuilder("第");
        if (予定情報 != null) {
            開催番号 = 開催番号.append(予定情報.getShinsakaiKaisaiNo()).append("回審査会");
            div.getTxtShinsakaiName().setValue(開催番号.toRString());
            div.getTxtGogitaiNumber().setValue(予定情報.getGogitaiMei());
            div.getTxtYoteiTeiin().setValue(new Decimal(予定情報.getShinsakaiYoteiTeiin()));
            div.getTxtWaritsukeNinzu().setValue(new Decimal(予定情報.getShinsakaiWariateZumiNinzu()));
            try {
                div.getTxtStatus().setValue(ShinsakaiShinchokuJokyo.toValue(予定情報.getShinsakaiShinchokuJokyo().getColumnValue()).get名称());
            } catch (IllegalArgumentException e) {
                div.getTxtStatus().setValue(RString.EMPTY);
            }
            div.getTxtShinsakaiKaijo().setValue(予定情報.getShinsakaiKaisaiBashoName());
            div.getTxtShinsakaiChiku().setValue(予定情報.getShinsakaiKaisaiBashoCode());
            if (予定情報.getShinsakaiKaisaiChikuCode() != null) {
                div.getTxtShinsakauChikuName().setValue(CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援,
                        new CodeShubetsu(CODESHUBETSU_5001), 予定情報.getShinsakaiKaisaiChikuCode(),
                        FlexibleDate.getNowDate()));
            }
            div.getTxtKaisaiDate().setValue(予定情報.getShinsakaiKaisaiYoteiYMD());
            if (!RString.isNullOrEmpty(予定情報.getShinsakaiKaishiYoteiTime())) {
                div.getTxtYoteiKaishiTime().setValue(RTime.parse(予定情報.getShinsakaiKaishiYoteiTime().insert(2, ":")));
            }
            if (!RString.isNullOrEmpty(予定情報.getShinsakaiShuryoYoteiTime())) {
                div.getTxtYoteiShuryoTime().setValue(RTime.parse(予定情報.getShinsakaiShuryoYoteiTime().insert(2, ":")));
            }
            if (予定情報.isGogitaiSeishinkaSonzaiFlag()) {
                List<RString> key = new ArrayList<>();
                key.add(new RString("key0"));
                div.getChkNinchishoOnly().setSelectedItemsByKey(key);
            }
            div.getTxtShinsakaiKaijoKekka().setValue(予定情報.getShinsakaiKaisaiBashoName());
            div.getTxtShinsakaiChikuKekka().setValue(予定情報.getShinsakaiKaisaiBashoCode());
            if (予定情報.getShinsakaiKaisaiChikuCode() != null) {
                div.getTxtShinsakauChikuNameKekka().setValue(CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援,
                        new CodeShubetsu(CODESHUBETSU_5001), 予定情報.getShinsakaiKaisaiChikuCode(),
                        FlexibleDate.getNowDate()));
            }
            div.getTxtKaisaiDateKekka().setValue(予定情報.getShinsakaiKaisaiYMD());
            if (!RString.isNullOrEmpty(予定情報.getShinsakaiKaishiTime())) {
                div.getTxtKaishiTime().setValue(RTime.parse(予定情報.getShinsakaiKaishiTime().insert(2, ":")));
            }
            if (!RString.isNullOrEmpty(予定情報.getShinsakaiShuryoTime())) {
                div.getTxtShuryoTime().setValue(RTime.parse(予定情報.getShinsakaiShuryoTime().insert(2, ":")));
            }
            div.getTxtShoyoTime().setValue(new Decimal(予定情報.getShoyoJikanGokei()));
            div.getTxtJissiNinzu().setValue(new Decimal(予定情報.getShinsakaiJisshiNinzu()));
        }

        List<dgTaishoshaIchiran_Row> listRow = new ArrayList();
        for (ShinsakaiTaishoshaBusiness shinsakaiTai : 一覧情報) {
            dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row();
            TextBoxNum no = new TextBoxNum();
            no.setValue(Decimal.valueOf(shinsakaiTai.getShinsakaiOrder()));
            row.setNo(no);
            row.setHokenshaNo(shinsakaiTai.getShoKisaiHokenshaNo());
            row.setHokenshaName(shinsakaiTai.getShichosonMeisho());

            row.setHihokenshaNumber(shinsakaiTai.getHihokenshaNo());
            row.setShimei(shinsakaiTai.getHihokenshaName().getColumnValue());
            try {
                row.setSeibetsu(Seibetsu.toValue(shinsakaiTai.getSeibetsu().getColumnValue()).get名称());
            } catch (IllegalArgumentException | NullPointerException e) {
                row.setSeibetsu(RString.EMPTY);
            }
            try {
                row.setHihokenshaKubun(HihokenshaKubunCode.toValue(shinsakaiTai.getHihokenshaKubunCode()).get名称());
            } catch (IllegalArgumentException | NullPointerException e) {
                row.setHihokenshaKubun(RString.EMPTY);
            }
            try {
                row.setSihinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(
                        shinsakaiTai.getNinteiShinseiShinseijiKubunCode().getColumnValue()).get名称());
            } catch (IllegalArgumentException | NullPointerException e) {
                row.setSihinseiKubunShinseiji(RString.EMPTY);
            }
            row.getShinseiDay().setValue(shinsakaiTai.getNinteiShinseiYMD());
            try {
                row.setKonkaiIchijiHantei(IchijiHanteiKekkaCode09.toValue(shinsakaiTai.getIchijiHanteiKekkaCode().getColumnValue()).get名称());
            } catch (IllegalArgumentException | NullPointerException e) {
                row.setKonkaiIchijiHantei(RString.EMPTY);
            }
            try {
                row.setKonkaiNijiHantei(YokaigoJotaiKubun09.toValue(
                        shinsakaiTai.getNijiHanteiYokaigoJotaiKubunCode().getColumnValue()).get名称());
            } catch (IllegalArgumentException | NullPointerException e) {
                row.setKonkaiNijiHantei(RString.EMPTY);
            }
            if (shinsakaiTai.ninchishoNichijoSeikatsuJiritsudoCode() != null) {
                try {
                    
                    row.setChosahyoNinchido(NinchishoNichijoSeikatsuJiritsudoCode.toValue(
                            shinsakaiTai.ninchishoNichijoSeikatsuJiritsudoCode().getColumnValue()).get名称());
                } catch (IllegalArgumentException | NullPointerException e) {
                    row.setChosahyoNinchido(RString.EMPTY);
                }
            }
            row.setChosaKikan(shinsakaiTai.getJigyoshaMeisho());
            row.setChosain(shinsakaiTai.getChosainShimei());
            row.getSaiChosaIraiKaisu().setValue(new Decimal(shinsakaiTai.getSaiChosaIraiKaisu()));
            row.setIryoKikan(shinsakaiTai.getIryoKikanMeisho());
            row.setShujii(shinsakaiTai.getShujiiName());
            row.getSaiSakuseiIraiKaisu().setValue(new Decimal(shinsakaiTai.getSaiSakuseiIraiKaisu()));
            if (shinsakaiTai.getShogaiNichijoSeikatsuJiritsudoCode() != null) {
                try {
                    row.setChosahyoNetakirido(ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                            shinsakaiTai.getShogaiNichijoSeikatsuJiritsudoCode().getColumnValue()).get名称());
                } catch (IllegalArgumentException e) {
                    row.setChosahyoNetakirido(RString.EMPTY);
                }
            }
            row.setShinseishoKanriNo(shinsakaiTai.getShinseishoKanriNo().getColumnValue());
            listRow.add(row);
            アクセスログ(shinsakaiTai.getShinseishoKanriNo().getColumnValue());
        }
        div.getDgTaishoshaIchiran().setDataSource(listRow);
    }

    private void アクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(SHIKI, 管理番号,
                申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
