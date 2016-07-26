/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6080001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJissekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.IsGinkoFurikomiShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiryonyuryoku.ShujiiIkenshoSakuseiryoNyuryokuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.ShujiiIkenshoSakuseiryoNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.dgShujii_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shujii.ShiteiiFlg;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 主治医意見書作成料入力のHandlerクラスです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public class ShujiiIkenshoSakuseiryoNyuryokuHandler {

    private static final RString 銀行振込_する = new RString("する");
    private static final RString 銀行振込_しない = new RString("しない");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString コンマ = new RString(",");
    private final ShujiiIkenshoSakuseiryoNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShujiiIkenshoSakuseiryoNyuryokuHandler(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 初期化の設定します。
     */
    public void onLoad() {
        div.getShujiiKensakuJoken().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getShujiiKensakuJoken().getTxtMaxCount().setValue(
                new Decimal(DbBusinessConfig.get(
                                ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 検索条件の入力項目をクリアします。
     */
    public void clearValue() {
        div.getShujiiKensakuJoken().getTxtShujiiei().clearValue();
        div.getShujiiKensakuJoken().getDdlHihokenshaNameMatchType().setIsBlankLine(true);
        div.getShujiiKensakuJoken().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getShujiiKensakuJoken().getTxtKensakuNendo().clearFromValue();
        div.getShujiiKensakuJoken().getTxtKensakuNendo().clearToValue();
        div.getShujiiKensakuJoken().getTxtMaxCount().clearValue();
    }

    /**
     * 主治医情報のパラメータを作成します。
     *
     * @return ShujiiIkenshoSakuseiryoNyuryokuParameter
     */
    public ShujiiIkenshoSakuseiryoNyuryokuParameter setShujiiParameter() {
        ShujiiIkenshoSakuseiryoNyuryokuParameter parameter = ShujiiIkenshoSakuseiryoNyuryokuParameter
                .createParam主治医情報(
                        div.getShujiiKensakuJoken().getTxtMaxCount().getValue().intValue(),
                        div.getShujiiKensakuJoken().getCcdHokenshaList().getSelectedItem().get市町村コード().value(),
                        div.getShujiiKensakuJoken().getTxtShujiiei().getValue(),
                        div.getShujiiKensakuJoken().getDdlHihokenshaNameMatchType().getSelectedValue());
        return parameter;
    }

    /**
     * 主治医実績一覧のパラメータを作成します。
     *
     * @return ShujiiIkenshoSakuseiryoNyuryokuParameter
     */
    public ShujiiIkenshoSakuseiryoNyuryokuParameter setShujiiJissekiIchiranParameter() {
        RString nendoFrom;
        RString nendoTo;
        if (div.getShujiiKensakuJoken().getTxtKensakuNendo().getFromValue() == null) {
            nendoFrom = RString.EMPTY;
        } else {
            nendoFrom = div.getShujiiKensakuJoken().getTxtKensakuNendo().getFromValue().getYearMonth().toDateString();
        }
        if (div.getShujiiKensakuJoken().getTxtKensakuNendo().getToValue() == null) {
            nendoTo = RString.EMPTY;
        } else {
            nendoTo = div.getShujiiKensakuJoken().getTxtKensakuNendo().getToValue().getYearMonth().toDateString();
        }
        ShujiiIkenshoSakuseiryoNyuryokuParameter parameter = ShujiiIkenshoSakuseiryoNyuryokuParameter
                .createParam主治医実績一覧(
                        div.getShujii().getDgShujii().getClickedItem().getShichosonCode(),
                        div.getShujii().getDgShujii().getClickedItem().getShokisaiHokenshaNo(),
                        div.getShujii().getDgShujii().getClickedItem().getCode(),
                        div.getShujii().getDgShujii().getClickedItem().getShujiiIryoKikanCode(),
                        nendoFrom,
                        nendoTo);
        return parameter;
    }

    /**
     * 主治医情報を画面に設定します。
     *
     * @param businessList 主治医情報
     */
    public void onClik_SearchBtn(List<ShujiiJohoBusiness> businessList) {
        List<dgShujii_Row> rowList = new ArrayList<>();
        for (ShujiiJohoBusiness business : businessList) {
            dgShujii_Row row = new dgShujii_Row();
            row.setShokisaiHokenshaNo(business.get証記載保険者番号());
            row.setShichosonCode(business.get市町村コード());
            row.setHokensha(business.get市町村名称());
            row.setCode(business.get主治医コード());
            row.setShujiiName(business.get主治医氏名());
            row.setShujiiKana(nullToEmpty(business.get主治医カナ()));
            row.setIryokikan(business.get医療機関名称());
            row.setShinryokaName(nullToEmpty(business.get診療科名称()));
            if (business.is指定医フラグ()) {
                row.setShiteiiFlag(ShiteiiFlg.指定医になれる.get名称());
            } else {
                row.setShiteiiFlag(ShiteiiFlg.なれない.get名称());
            }
            row.setJokyoFlag(ShujiiJokyo.toValue(business.is状況フラグ()).get名称());
            row.setShujiiIryoKikanCode(business.get主治医医療機関コード());
            rowList.add(row);
        }
        div.getShujii().getDgShujii().setDataSource(rowList);
    }

    /**
     * 主治医情報一覧を画面に設定します。
     *
     * @param businessList 主治医情報一覧
     */
    public void onClik_SelectBtn(List<ShujiiJissekiIchiranBusiness> businessList) {
        div.getShinseiJoho().getTxtIryoKikanCode().setValue(div.getShujii().getDgShujii().getClickedItem().getShujiiIryoKikanCode());
        div.getShinseiJoho().getTxtIryoKikanName().setValue(div.getShujii().getDgShujii().getClickedItem().getIryokikan());
        div.getShinseiJoho().getTxtShujiiCode().setValue(div.getShujii().getDgShujii().getClickedItem().getCode());
        div.getShinseiJoho().getTxtShujiiName().setValue(div.getShujii().getDgShujii().getClickedItem().getShujiiName());
        div.setHdnShichosonCode(div.getShujii().getDgShujii().getClickedItem().getShichosonCode());
        List<dgShinsakaiIin_Row> rowList = new ArrayList<>();
        for (ShujiiJissekiIchiranBusiness business : businessList) {
            dgShinsakaiIin_Row row = new dgShinsakaiIin_Row();
            row.setColumnState(RString.EMPTY);
            row.setShinseibi(dateFormat(business.get認定申請年月日()));
            row.setNinteiShinseiKubun(NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分_申請時コード()).get名称());
            row.setShujiiIryoKikan(nullToEmpty(business.get医療機関名称()));
            row.setShujii(business.get主治医氏名());
            row.setIraiNengappi(dateFormat(business.get主治医意見書作成依頼年月日()));
            row.setKinyuNengappi(dateFormat(business.get主治医意見書記入年月日()));
            row.setJuryoNengappi(dateFormat(business.get主治医意見書受領年月日()));
            row.setIshiKubun(IshiKubunCode.toValue(business.get医師区分コード()).get名称());
            row.setIkenshoSakuseiryo(DecimalFormatter.toコンマ区切りRString(new Decimal(business.get主治医意見書作成料()), 0));
            row.setIkenshoBettoShinryohi(DecimalFormatter.toコンマ区切りRString(new Decimal(business.get主治医意見書別途診療費()), 0));
            row.setIkenshoHoshu(DecimalFormatter.toコンマ区切りRString(new Decimal(business.get主治医意見書報酬()), 0));
            row.setShiharaiMemo(nullToEmpty(business.get主治医意見書報酬支払メモ()));
            row.setFurikomi(IsGinkoFurikomiShutsuryoku.toValue(business.is銀行振込出力済フラグ()).get名称());
            row.setShinseishoKanriNo(business.get申請書管理番号());
            row.setIkenshoIraiRirekiNo(business.get主治医意見書作成依頼履歴番号_意見書情報());
            row.setShujiiIryoKikanCode(business.get主治医医療機関コード());
            row.setShujiiCode(business.get主治医コード());
            if (business.is指定医フラグ()) {
                row.setShiteiiFlag(ShiteiiFlg.指定医になれる.get名称());
            } else {
                row.setShiteiiFlag(ShiteiiFlg.なれない.get名称());
            }
            row.setHoshuJissekiRirekiNo(business.get主治医意見書作成依頼履歴番号_報酬実績情報());
            rowList.add(row);
        }
        div.getShinseiJoho().getDgShinsakaiIin().setDataSource(rowList);
    }

    /**
     * 修正/削除ボタンを押下します。
     *
     * @param state 処理状態
     */
    public void onClick_ModifyOrDeleteBtn(RString state) {
        dgShinsakaiIin_Row row = div.getShinseiJoho().getDgShinsakaiIin().getClickedItem();
        div.setHdnState(state);
        if (状態_削除.equals(state)) {
            div.getShinseiJohoMeisai().getDdlZaitakuShisetsuKubun().setDisabled(true);
            div.getShinseiJohoMeisai().getDdlIkenshoSakuseiKaisuKubun().setDisabled(true);
            div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().setDisabled(true);
            div.getShinseiJohoMeisai().getTxtShiharaiMemo().setDisabled(true);
            div.getShinseiJohoMeisai().getRadGinkoFurikomi().setDisabled(true);
        } else {
            div.getShinseiJohoMeisai().getDdlZaitakuShisetsuKubun().setDisabled(false);
            div.getShinseiJohoMeisai().getDdlIkenshoSakuseiKaisuKubun().setDisabled(false);
            div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().setDisabled(false);
            div.getShinseiJohoMeisai().getTxtShiharaiMemo().setDisabled(false);
            div.getShinseiJohoMeisai().getRadGinkoFurikomi().setDisabled(false);
        }
        setMeisai(row);
    }

    /**
     * 意見書報酬の計算です。
     */
    public void onChange_Kuben() {
        if (div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().getValue() != null) {
            div.getShinseiJohoMeisai().getTxtIkenshoHoshu().setValue(div.getShinseiJohoMeisai().getTxtIkenshoSakuseiryo().getValue()
                    .add(div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().getValue()));
        }
    }

    /**
     * 意見書作成料を設定します。
     *
     * @param tanka 単価
     */
    public void setTanka(Decimal tanka) {
        div.getShinseiJohoMeisai().getTxtIkenshoSakuseiryo().setValue(tanka);
    }

    /**
     * 「入力を取りやめる」ボタンを押下します。
     */
    public void onClick_ToriyameruBtn() {
        setMeisai(div.getShinseiJoho().getDgShinsakaiIin().getClickedItem());
    }

    /**
     * 「登録する」ボタンを押下します。
     */
    public void onClick_TourokuBtn() {
        List<dgShinsakaiIin_Row> rowList = div.getShinseiJoho().getDgShinsakaiIin().getDataSource();
        int rowCount = div.getShinseiJoho().getDgShinsakaiIin().getClickedItem().getId();
        dgShinsakaiIin_Row row = rowList.get(rowCount);
        if (状態_追加.equals(row.getColumnState())) {
            if (状態_修正.equals(div.getHdnState())) {
                row.setColumnState(状態_追加);
                setIchiran(row);
            } else if (状態_削除.equals(div.getHdnState())) {
                row.setColumnState(RString.EMPTY);
            }
        } else if (状態_修正.equals(div.getHdnState())) {
            if (RString.isNullOrEmpty(row.getHoshuJissekiRirekiNo())) {
                row.setColumnState(状態_追加);
            } else {
                row.setColumnState(状態_修正);
            }
            setIchiran(row);
        } else if (状態_削除.equals(div.getHdnState())) {
            row.setColumnState(状態_削除);
        }
    }

    /**
     * 「保存する」ボタンを押下し、新規処理を続けます。
     *
     * @param row 主治医実績一覧
     * @return ShujiiIkenshoHoshuJissekiJohoBuilder
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder onClick_Add(dgShinsakaiIin_Row row) {
        ShujiiIkenshoHoshuJissekiJoho joho = new ShujiiIkenshoHoshuJissekiJoho(
                div.getShinseiJoho().getTxtIryoKikanCode().getValue(),
                div.getShinseiJoho().getTxtShujiiCode().getValue(),
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()));
        ShujiiIkenshoHoshuJissekiJohoBuilder builder = joho.createBuilderForEdit();
        builder.set主治医意見書作成依頼年月日(new FlexibleDate(new RDate(row.getIraiNengappi().toString()).toString()));
        builder.set主治医意見書記入年月日(new FlexibleDate(new RDate(row.getKinyuNengappi().toString()).toString()));
        builder.set主治医意見書受領年月日(new FlexibleDate(new RDate(row.getJuryoNengappi().toString()).toString()));
        builder.set医師区分コード(new Code(IshiKubunCode.valueOf(row.getIshiKubun().toString()).getコード()));
        builder.set主治医意見書作成料(toDecimal(row.getIkenshoSakuseiryo()).intValue());
        builder.set主治医意見書別途診療費(toDecimal(row.getIkenshoBettoShinryohi()).intValue());
        builder.set主治医意見書報酬(toDecimal(row.getIkenshoHoshu()).intValue());
        builder.set主治医意見書報酬支払年月日(FlexibleDate.EMPTY);
        builder.set主治医意見書報酬支払メモ(row.getShiharaiMemo());
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
     * @param row 主治医実績一覧
     * @return ShujiiIkenshoHoshuJissekiJohoBuilder
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder onClick_Update(
            Models<ShujiiIkenshoHoshuJissekiJohoIdentifier, ShujiiIkenshoHoshuJissekiJoho> models, dgShinsakaiIin_Row row) {
        ShujiiIkenshoHoshuJissekiJohoIdentifier key = new ShujiiIkenshoHoshuJissekiJohoIdentifier(
                div.getShinseiJoho().getTxtIryoKikanCode().getValue(),
                div.getShinseiJoho().getTxtShujiiCode().getValue(),
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()));
        ShujiiIkenshoHoshuJissekiJoho joho = models.get(key);
        ShujiiIkenshoHoshuJissekiJohoBuilder builder = joho.createBuilderForEdit();
        builder.set主治医意見書作成料(toDecimal(row.getIkenshoSakuseiryo()).intValue());
        builder.set主治医意見書別途診療費(toDecimal(row.getIkenshoBettoShinryohi()).intValue());
        builder.set主治医意見書報酬(toDecimal(row.getIkenshoHoshu()).intValue());
        builder.set主治医意見書報酬支払メモ(row.getShiharaiMemo());
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(row.getFurikomi())) {
            builder.set銀行振込出力フラグ(true);
        } else {
            builder.set銀行振込出力フラグ(false);
        }
        joho.toEntity().setState(EntityDataState.Modified);
        return builder;
    }

    private void setIchiran(dgShinsakaiIin_Row row) {
        row.setShinseibi(dateFormat(new RString(div.getShinseiJohoMeisai().getTxtShinseibi().getValue().toString())));
        row.setShujiiIryoKikan(div.getShinseiJohoMeisai().getCcdShujiiIryokikanAndShujiiInput().getIryoKikanName());
        row.setShujii(div.getShinseiJohoMeisai().getCcdShujiiIryokikanAndShujiiInput().getShujiiName());
        row.setIraiNengappi(dateFormat(new RString(div.getShinseiJohoMeisai().getXtIkenshoSakuseiIraiNengappi().getValue().toString())));
        row.setKinyuNengappi(dateFormat(new RString(div.getShinseiJohoMeisai().getTxtIkenshoKinyuNengappi().getValue().toString())));
        row.setJuryoNengappi(dateFormat(new RString(div.getShinseiJohoMeisai().getTxtIkenshoJuryoNengappi().getValue().toString())));
        row.setIshiKubun(div.getShinseiJohoMeisai().getTxtIshiKubun().getValue());
        row.setIkenshoSakuseiryo(DecimalFormatter.toコンマ区切りRString(div.getShinseiJohoMeisai().getTxtIkenshoSakuseiryo().getValue(), 0));
        row.setIkenshoBettoShinryohi(DecimalFormatter.toコンマ区切りRString(
                div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().getValue(), 0));
        row.setIkenshoHoshu(DecimalFormatter.toコンマ区切りRString(div.getShinseiJohoMeisai().getTxtIkenshoHoshu().getValue(), 0));
        row.setShiharaiMemo(div.getShinseiJohoMeisai().getTxtShiharaiMemo().getValue());
        if (銀行振込_する.equals(div.getShinseiJohoMeisai().getRadGinkoFurikomi().getSelectedValue())) {
            row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力済.get名称());
        } else {
            row.setFurikomi(IsGinkoFurikomiShutsuryoku.出力未.get名称());
        }
        row.setShujiiIryoKikanCode(div.getShinseiJohoMeisai().getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        row.setShujiiCode(div.getShinseiJohoMeisai().getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        if (div.getShinseiJohoMeisai().getCcdShujiiIryokikanAndShujiiInput().hasShiteii()) {
            row.setShiteiiFlag(ShiteiiFlg.指定医になれる.get名称());
        } else {
            row.setShiteiiFlag(ShiteiiFlg.なれない.get名称());
        }
    }

    private void setMeisai(dgShinsakaiIin_Row row) {
        div.getShinseiJohoMeisai().getTxtShinseibi().setValue(toFlexibleDate(row.getShinseibi()));
        div.getShinseiJohoMeisai().getCcdShujiiIryokikanAndShujiiInput().initialize(
                new LasdecCode(div.getHdnShichosonCode()),
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                SubGyomuCode.DBE認定支援,
                row.getShujiiIryoKikanCode(),
                row.getShujiiIryoKikan(),
                row.getShujiiCode(),
                row.getShujii());
        div.getShinseiJohoMeisai().getXtIkenshoSakuseiIraiNengappi().setValue(toFlexibleDate(row.getIraiNengappi()));
        div.getShinseiJohoMeisai().getTxtIkenshoKinyuNengappi().setValue(toFlexibleDate(row.getKinyuNengappi()));
        div.getShinseiJohoMeisai().getTxtIkenshoJuryoNengappi().setValue(toFlexibleDate(row.getJuryoNengappi()));
        div.getShinseiJohoMeisai().getTxtIshiKubun().setValue(row.getIshiKubun());
        div.getShinseiJohoMeisai().getTxtIkenshoSakuseiryo().setValue(toDecimal(row.getIkenshoSakuseiryo()));
        div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().setValue(toDecimal(row.getIkenshoBettoShinryohi()));
        div.getShinseiJohoMeisai().getTxtIkenshoHoshu().setValue(div.getShinseiJohoMeisai().getTxtIkenshoSakuseiryo().getValue()
                .add(div.getShinseiJohoMeisai().getTxtIkenshoBettoShinsahi().getValue()));
        div.getShinseiJohoMeisai().getTxtShiharaiMemo().setValue(row.getShiharaiMemo());
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(row.getFurikomi())) {
            div.getShinseiJohoMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        } else {
            div.getShinseiJohoMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        }
    }

    private Decimal toDecimal(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return Decimal.ZERO;
        } else {
            return new Decimal(obj.replace(コンマ, RString.EMPTY).toString());
        }
    }

    private RString dateFormat(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new FlexibleDate(obj).wareki().toDateString();
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
