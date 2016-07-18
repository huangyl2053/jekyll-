/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.IsGinkoFurikomiShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteiChosaHoshuTankaMybatisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaMybatisParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.HomonChosaItakuNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.dgChosain_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 認定調査委託料入力クラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public class HomonChosaItakuNyuryokuHandler {

    private final HomonChosaItakuNyuryokuDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_更新 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 銀行振込 = new RString("出力済");
    private static final RString 銀行振込_出力済 = new RString("key0");
    private static final RString 銀行振込_出力未 = new RString("key1");
    private static final RString 単純照会状態 = new RString("SimpleShokaiMode");
    private static final RString 有効 = new RString("有効");
    private static final RString 無効 = new RString("無効");
    private static final RString コンマ = new RString(",");
    private static final int 年月 = 6;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HomonChosaItakuNyuryokuHandler(HomonChosaItakuNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化です。
     */
    public void intialize() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTextBoxNum().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTextBoxNum().setMaxValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 調査委託料検索条件をクリアする。
     */
    public void btnKyufuJissekiSearchClear() {
        div.getChosainShimei().clearValue();
        div.getTxtKensakuNendo().clearFromValue();
        div.getTxtKensakuNendo().clearToValue();
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getDdlHihokenshaNameMatchType().setSelectedKey(new RString("key0"));
        div.getTextBoxNum().clearValue();
    }

    /**
     * 画面調査員一覧編集です。
     *
     * @param list List<NinteiChosaHoshuJissekiJohoBusiness>
     */
    public void setDgChosain(List<NinteiChosaHoshuJissekiJohoBusiness> list) {
        List<dgChosain_Row> dgChosainList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (NinteiChosaHoshuJissekiJohoBusiness business : list) {
                dgChosain_Row dgchosain_Row = new dgChosain_Row();
                dgchosain_Row.setShokisaiHokenshaNo(nullToEmpty(business.get証記載保険者番号()));
                dgchosain_Row.setShichosonCode(nullToEmpty(business.get市町村コード()));
                dgchosain_Row.setHokensha(nullToEmpty(business.get市町村名称()));
                dgchosain_Row.setNinteiChosainCode(nullToEmpty(business.get認定調査員コード()));
                dgchosain_Row.setChosainShimei(nullToEmpty(business.get調査員氏名()));
                dgchosain_Row.setChosainKanaShimei(nullToEmpty(business.get調査員氏名カナ()));
                dgchosain_Row.setChosainShikaku(Sikaku.toValue(nullToEmpty(business.get調査員資格())).get名称());
                dgchosain_Row.setShozokuKikanName(nullToEmpty(business.get所属機関名称()));
                if (business.is状況フラグ()) {
                    RString 状況フラグ = 有効;
                    dgchosain_Row.setJokyoFlag(状況フラグ);
                } else {
                    RString 状況フラグ = 無効;
                    dgchosain_Row.setJokyoFlag(状況フラグ);
                }
                dgchosain_Row.setNintechosaItakusakiCode(business.get認定調査委託先コード());
                dgchosain_Row.setJigyoshaMeisho(business.get事業者名称());
                dgChosainList.add(dgchosain_Row);
            }
        }
        div.getDgChosain().setDataSource(dgChosainList);
    }

    /**
     * 調査実績一覧Gridの編集です。
     *
     * @param list List<NinteichosahyoGaikyoChosaBusiness>
     */
    public void setDgShinsakaiIin(List<NinteichosahyoGaikyoChosaBusiness> list) {
        List<dgShinsakaiIin_Row> dgChosainList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (NinteichosahyoGaikyoChosaBusiness business : list) {
                dgShinsakaiIin_Row row = new dgShinsakaiIin_Row();
                row.setShinseibi(nullToEmpty(business.get認定申請年月日().wareki().toDateString()));
                row.setNinteiShinseiKubun(nullToEmpty(NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分申請時コード()).get名称()));
                row.setNinteiChosaItakusaki(nullToEmpty(business.get事業者名称()));
                row.setNinteiChosain(nullToEmpty(business.get調査員氏名()));
                row.setIraiNengappi(nullToEmpty(business.get認定調査依頼年月日().wareki().toDateString()));
                row.setJisshiNengappi(nullToEmpty(business.get認定調査実施年月日().wareki().toDateString()));
                row.setJuryoNengappi(nullToEmpty(business.get認定調査受領年月日().wareki().toDateString()));
                row.setShurui(nullToEmpty(business.get認定調査実施場所名称()));
                row.setNinteiChosaItakuryo(DecimalFormatter
                        .toコンマ区切りRString(new Decimal((business.get認定調査委託料())), 0));
                row.setShiharaiMemo(nullToEmpty(business.get認定調査委託料支払メモ()));
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.toValue(business.is銀行振込出力フラグ()).get名称());
                row.setShinseishoKanriNo(nullToEmpty(business.get申請書管理番号()));
                row.setNinteichosaIraiRirekiNo(nullToEmpty(business.get認定調査依頼履歴番号()));
                row.setNintechosaItakusakiCode(nullToEmpty(business.get認定調査委託先コード()));
                row.setNinteichosainCode(nullToEmpty(business.get認定調査委託先コード()));
                row.setRaiRirekiNo(nullToEmpty(business.get履歴番号()));
                if (nullToEmpty(business.get履歴番号()).isNullOrEmpty()) {
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                }
                dgChosainList.add(row);
                div.getDgShinsakaiIin().setDataSource(dgChosainList);
            }
        }
    }

    /**
     * 「入力を取りやめる」ボタンを押下し、編集内容クリアです。
     */
    public void kuria() {
        if (div.getHdt状態().equals(状態_更新)) {
            div.getTxtShiharaiMemo().clearValue();
            div.getTxtNinteiChosaItakuryo().clearValue();
            div.getRadGinkoFurikomi().setSelectedKey(銀行振込_出力済);
        }
    }

    /**
     * 一覧状態「更新」の編集です。
     *
     */
    public void set状態_更新() {
        div.getTxtShinseibi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getShinseibi()));
        div.getCcdChosaItakusakiAndChosainInput().initialize(単純照会状態, div.getDgShinsakaiIin().getClickedItem().getNintechosaItakusakiCode(),
                div.getDgShinsakaiIin().getClickedItem().getNinteiChosaItakusaki(),
                div.getDgShinsakaiIin().getClickedItem().getNinteichosainCode(),
                div.getDgShinsakaiIin().getClickedItem().getNinteiChosain());
        div.getTxtNinteiChosaIraiNengappi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getJisshiNengappi()));
        div.getTxtNinteiChosaJisshiNengappi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getIraiNengappi()));
        div.getTxtNinteiJuryoNengappi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getJuryoNengappi()));
        div.getTxtHomonShurui().setValue(div.getDgShinsakaiIin().getClickedItem().getShurui() == null
                ? RString.EMPTY : div.getDgShinsakaiIin().getClickedItem().getShurui());
        div.getTxtNinteiChosaItakuryo().setValue(toDecimal(div.getDgShinsakaiIin().getClickedItem().getNinteiChosaItakuryo()));
        div.getTxtShiharaiMemo().setValue(div.getDgShinsakaiIin().getClickedItem().getShiharaiMemo());
        if (銀行振込.equals(div.getDgShinsakaiIin().getClickedItem().getFurikomi())) {
            div.getRadGinkoFurikomi().setSelectedKey(銀行振込_出力済);
        } else {
            div.getRadGinkoFurikomi().setSelectedKey(銀行振込_出力未);
        }
        if (div.getDgShinsakaiIin().getClickedItem().getRaiRirekiNo().isNullOrEmpty()) {
            div.setHdt状態(状態_追加);
        } else {
            div.setHdt状態(状態_更新);
        }
        div.getTxtShiharaiMemo().setDisabled(false);
        div.getTxtNinteiChosaItakuryo().setDisabled(false);
        div.getRadGinkoFurikomi().setDisabled(false);
    }

    /**
     * 一覧状態「削除」の編集です。
     */
    public void set状態_削除() {
        div.getTxtShinseibi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getShinseibi()));
        div.getCcdChosaItakusakiAndChosainInput().initialize(単純照会状態, div.getDgShinsakaiIin().getClickedItem().getNintechosaItakusakiCode(),
                div.getDgShinsakaiIin().getClickedItem().getNinteiChosaItakusaki(),
                div.getDgShinsakaiIin().getClickedItem().getNinteichosainCode(),
                div.getDgShinsakaiIin().getClickedItem().getNinteiChosain());
        div.getTxtNinteiChosaIraiNengappi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getJisshiNengappi()));
        div.getTxtNinteiChosaJisshiNengappi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getIraiNengappi()));
        div.getTxtNinteiJuryoNengappi().setValue(toFlexibleDate(div.getDgShinsakaiIin().getClickedItem().getJuryoNengappi()));
        div.getTxtHomonShurui().setValue(div.getDgShinsakaiIin().getClickedItem().getShurui());
        div.getTxtNinteiChosaItakuryo().setValue(toDecimal(div.getDgShinsakaiIin().getClickedItem().getNinteiChosaItakuryo()));
        div.getTxtShiharaiMemo().setValue(div.getDgShinsakaiIin().getClickedItem().getShiharaiMemo());
        if (銀行振込.equals(div.getDgShinsakaiIin().getClickedItem().getFurikomi())) {
            div.getRadGinkoFurikomi().setSelectedKey(銀行振込_出力済);
        } else {
            div.getRadGinkoFurikomi().setSelectedKey(銀行振込_出力未);
        }
        div.getTxtShiharaiMemo().setDisabled(true);
        div.getTxtNinteiChosaItakuryo().setDisabled(true);
        div.getRadGinkoFurikomi().setDisabled(true);
        div.setHdt状態(状態_削除);
    }

    /**
     * 「登録する」ボタンを押下し、編集です。
     */
    public void setbtnToroku() {
        List<dgShinsakaiIin_Row> dgChosainList = div.getDgShinsakaiIin().getDataSource();
        int rowCount = div.getDgShinsakaiIin().getClickedItem().getId();
        dgShinsakaiIin_Row row = dgChosainList.get(rowCount);
        if (状態_更新.equals(div.getHdt状態())) {
            row.setNinteiChosaItakuryo(DecimalFormatter.toコンマ区切りRString(div.getTxtNinteiChosaItakuryo().getValue(), 0));
            row.setShiharaiMemo(div.getTxtShiharaiMemo().getValue());
            if (銀行振込_出力済.equals(div.getRadGinkoFurikomi().getSelectedKey())) {
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力済.get名称());
            } else {
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力未.get名称());
            }
            row.setColumnState(状態_更新);
        } else if (状態_追加.equals(div.getHdt状態())) {
            row.setNinteiChosaItakuryo(new RString(div.getTxtNinteiChosaItakuryo().getValue().toString()));
            row.setShiharaiMemo(div.getTxtShiharaiMemo().getValue());
            if (銀行振込_出力済.equals(div.getRadGinkoFurikomi().getSelectedKey())) {
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力済.get名称());
            } else {
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力未.get名称());
            }
            row.setColumnState(状態_追加);
        } else if (状態_削除.equals(div.getHdt状態())) {
            if (銀行振込_出力済.equals(div.getRadGinkoFurikomi().getSelectedKey())) {
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力済.get名称());
            } else {
                row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力未.get名称());
            }
            row.setColumnState(状態_削除);
        }
    }

    /**
     * 「保存する」ボタンを押下し、新規処理を続けます。
     *
     * @param row 調査実績一覧
     * @return NinteiChosaHoshuJissekiJohoBuilder
     */
    public NinteiChosaHoshuJissekiJohoBuilder onClick_Add(dgShinsakaiIin_Row row) {
        NinteiChosaHoshuJissekiJoho joho = new NinteiChosaHoshuJissekiJoho(
                div.getTxtItakusakiCode().getValue(),
                div.getTxtChousaInCode().getValue(),
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString()));
        NinteiChosaHoshuJissekiJohoBuilder builder = joho.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo().toString()));
        builder.set認定調査依頼履歴番号(Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set認定調査員コード(div.getTxtChousaInCode().getValue());
        builder.set認定調査委託先コード(div.getTxtItakusakiCode().getValue());
        builder.set認定調査委託料(Integer.parseInt(row.getNinteiChosaItakuryo().toString()));
        builder.set認定調査委託料支払メモ(row.getShiharaiMemo());
        builder.set認定調査委託料支払年月日(FlexibleDate.EMPTY);
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(row.getFurikomi())) {
            builder.set銀行振込出力フラグ(true);
        } else {
            builder.set銀行振込出力フラグ(false);
        }
        joho.toEntity().setState(EntityDataState.Added);
        return builder;
    }

    /**
     * 「保存する」ボタンを押下し、更新処理を続けます。
     *
     * @param models 介護問合せ先情報
     * @param row 調査実績一覧
     * @return NinteiChosaHoshuJissekiJohoBuilder
     */
    public NinteiChosaHoshuJissekiJohoBuilder onClick_Update(
            Models<NinteiChosaHoshuJissekiJohoIdentifier, NinteiChosaHoshuJissekiJoho> models, dgShinsakaiIin_Row row) {
        NinteiChosaHoshuJissekiJohoIdentifier key = new NinteiChosaHoshuJissekiJohoIdentifier(
                div.getTxtItakusakiCode().getValue(),
                div.getTxtChousaInCode().getValue(),
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString()));
        NinteiChosaHoshuJissekiJoho joho = models.get(key);
        NinteiChosaHoshuJissekiJohoBuilder builder = joho.createBuilderForEdit();
        builder.set認定調査委託料(Integer.parseInt(row.getNinteiChosaItakuryo().toString()));
        builder.set認定調査委託料支払メモ(row.getShiharaiMemo());
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(row.getFurikomi())) {
            builder.set銀行振込出力フラグ(true);
        } else {
            builder.set銀行振込出力フラグ(false);
        }
        joho.toEntity().setState(EntityDataState.Modified);
        return builder;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    private Decimal toDecimal(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return Decimal.ZERO;
        } else {
            return new Decimal(obj.replace(コンマ, RString.EMPTY).toString());
        }
    }

    /**
     * 調査員一覧のパラメタ編集です。
     *
     * @param div HomonChosaItakuNyuryokuDiv
     * @return NinteiChosaHoshuJissekiJohoMybatisParameter
     */
    public NinteiChosaHoshuJissekiJohoMybatisParameter createParam_初期(HomonChosaItakuNyuryokuDiv div) {
        return NinteiChosaHoshuJissekiJohoMybatisParameter.createParam(
                div.getCcdHokenshaList().getSelectedItem().get市町村コード().value(),
                new Decimal(div.getTextBoxNum().getValue().toString()),
                div.getChosainShimei().getValue(),
                div.getDdlHihokenshaNameMatchType().getSelectedKey());
    }

    /**
     * 単価のパラメタ編集です。
     *
     * @param div HomonChosaItakuNyuryokuDiv
     * @return NinteiChosaHoshuJissekiJohoMybatisParameter
     */
    public NinteiChosaHoshuTankaMybatisParamter createParam_単価(HomonChosaItakuNyuryokuDiv div) {
        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        return NinteiChosaHoshuTankaMybatisParamter.createParam(
                div.getDgShinsakaiIin().getClickedItem().getShinseishoKanriNo(),
                Integer.parseInt(div.getDgShinsakaiIin().getClickedItem().getNinteichosaIraiRirekiNo().toString()),
                イメージ区分,
                new RDate(div.getDgShinsakaiIin().getClickedItem().getJisshiNengappi().toString()).toDateString().substring(0, 年月));

    }

    /**
     * 実績調査員一覧のパラメタ編集です。
     *
     * @param div HomonChosaItakuNyuryokuDiv
     * @return NinteichosahyoGaikyoChosaMybatisParameter
     */
    public NinteichosahyoGaikyoChosaMybatisParameter createParam_実績(HomonChosaItakuNyuryokuDiv div) {
        RString 検索年度月FROM;
        RString 検索年度月TO;
        if (div.getChosaItakuKensaku().getTxtKensakuNendo().getFromValue() == null) {
            検索年度月FROM = RString.EMPTY;
        } else {
            検索年度月FROM = div.getChosaItakuKensaku().getTxtKensakuNendo().getFromValue().getYearMonth().toDateString();
        }
        if (div.getChosaItakuKensaku().getTxtKensakuNendo().getToValue() == null) {
            検索年度月TO = RString.EMPTY;
        } else {
            検索年度月TO = div.getChosaItakuKensaku().getTxtKensakuNendo().getToValue().getYearMonth().toDateString();
        }
        return NinteichosahyoGaikyoChosaMybatisParameter.createParam(
                div.getChosain().getDgChosain().getClickedItem().getShichosonCode(),
                div.getChosain().getDgChosain().getClickedItem().getShokisaiHokenshaNo(),
                div.getChosain().getDgChosain().getClickedItem().getNinteiChosainCode(),
                検索年度月FROM,
                検索年度月TO);
    }

    /**
     * 単価の編集です。
     *
     * @param 単価List NinteichosahyoGaikyoChosaRelateEntity
     */
    public void 単価(List<NinteichosahyoGaikyoChosaBusiness> 単価List) {
        if (div.getDgShinsakaiIin().getClickedItem().getNinteiChosaItakuryo() == null) {
            for (NinteichosahyoGaikyoChosaBusiness business : 単価List) {
                div.getTxtNinteiChosaItakuryo().setValue(new Decimal(nullToEmpty(business.get単価()).toString()));
            }
        }
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }
}
