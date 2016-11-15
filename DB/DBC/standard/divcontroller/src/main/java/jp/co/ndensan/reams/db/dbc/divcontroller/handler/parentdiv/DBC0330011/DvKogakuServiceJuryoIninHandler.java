/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyoshaHolder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyoshaIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninshoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.juryoininbarai.SanteiKijungaku;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninshoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DBC0330011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DvKogakuServiceJuryoIninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.dgHaraiKettei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuJuryoininKeiyakuJigyoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninsho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 高額サービス費等受領委任払情報管理のHandlerです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvKogakuServiceJuryoIninHandler {

    private static final RString 帳票分類ID = new RString("DBC100031_KogakuServiceHiJyuryoItakuKeiyakuKakuninSho");
    private static final RString ROOTTITLE_追加 = new RString("高額サービス費等受領委任払決定登録・追加");
    private static final RString ROOTTITLE_修正 = new RString("高額サービス費等受領委任払決定登録・修正");
    private static final RString 空白 = RString.EMPTY;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString KEY_決定区分_承認する = new RString("key0");
    private static final RString KEY_決定区分_承認しない = new RString("key1");
    private static final int LENGTH_契約番号 = 8;
    private static final int LENGTH_契約番号西暦年度 = 4;
    private static final int LENGTH_契約番号下四桁 = 4;
    private static final RString ZERO_契約番号下四桁 = new RString("0000");
    private static final RString ONE_契約番号下四桁 = new RString("0001");
    private static final RString ZERO = new RString("0");
    private static final RString 円単位 = new RString("円");
    private final DvKogakuServiceJuryoIninDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     */
    public DvKogakuServiceJuryoIninHandler(DvKogakuServiceJuryoIninDiv div) {
        this.div = div;
    }

    /**
     * 初期化を処理します。
     *
     * @param 引き継ぎデータ TaishoshaKey
     * @param 画面タイトル DBC0330011StateName
     * @param resultList KogakuJuryoininKeiyakuJigyoshaResultのリスト
     */
    public void onLoad(TaishoshaKey 引き継ぎデータ, DBC0330011StateName 画面タイトル, List<KogakuJuryoininKeiyakuJigyoshaResult> resultList) {
        initialize(引き継ぎデータ);
        div.setOperateState(空白);

        if (DBC0330011StateName.修正 == 画面タイトル) {
            div.setRootTitle(ROOTTITLE_修正);
            グリッドに高額受領委任契約事業者情報を表示する(resultList);
        }
        if (DBC0330011StateName.追加 == 画面タイトル) {
            div.setRootTitle(ROOTTITLE_追加);
            div.setOperateState(追加);
            登録パネルに項目をクリアする();
        }
    }

    private void initialize(TaishoshaKey 引き継ぎデータ) {
        div.getCddAtenaInfo().initialize(引き継ぎデータ.get識別コード());
        div.getCddShikakuKihon().initialize(引き継ぎデータ.get被保険者番号());
        div.getDvKakuninsho().getCcdBunshoBango().initialize(new ReportId(帳票分類ID), FlexibleDate.getNowDate());
    }

    private void グリッドに高額受領委任契約事業者情報を表示する(List<KogakuJuryoininKeiyakuJigyoshaResult> resultList) {
        List<dgHaraiKettei_Row> rowList = new ArrayList<>();
        if (null != resultList && (!resultList.isEmpty())) {
            for (KogakuJuryoininKeiyakuJigyoshaResult result : resultList) {
                dgHaraiKettei_Row row = new dgHaraiKettei_Row();
                row.setRirekiNo(new RString(result.getKogakuJuryoininKeiyakuJigyosha().get履歴番号()));
                row.getShinseiDate().setValue(null == result.getKogakuJuryoininKeiyakuJigyosha().get申請年月日() ? FlexibleDate.EMPTY
                        : result.getKogakuJuryoininKeiyakuJigyosha().get申請年月日());
                row.getUketsukeDate().setValue(null == result.getKogakuJuryoininKeiyakuJigyosha().get受付年月日() ? FlexibleDate.EMPTY
                        : result.getKogakuJuryoininKeiyakuJigyosha().get受付年月日());
                row.getKetteiDate().setValue(null == result.getKogakuJuryoininKeiyakuJigyosha().get決定年月日() ? FlexibleDate.EMPTY
                        : result.getKogakuJuryoininKeiyakuJigyosha().get決定年月日());
                row.getShoninStartDate().setValue(null == result.getKogakuJuryoininKeiyakuJigyosha().get受領委任払適用開始年月日()
                        ? FlexibleDate.EMPTY : result.getKogakuJuryoininKeiyakuJigyosha().get受領委任払適用開始年月日());
                row.getShoninEndDate().setValue(null == result.getKogakuJuryoininKeiyakuJigyosha().get受領委任払適用終了年月日()
                        ? FlexibleDate.EMPTY : result.getKogakuJuryoininKeiyakuJigyosha().get受領委任払適用終了年月日());
                row.setJigyoshaNo(result.get所属事業者番号());
                row.setJigyoshaName(result.get事業者名称());
                row.setKetteiKubun(RString.isNullOrEmpty(result.getKogakuJuryoininKeiyakuJigyosha().get承認結果区分()) ? 空白
                        : ShoninKubun.toValue(result.getKogakuJuryoininKeiyakuJigyosha().get承認結果区分()).get名称());
                row.setJogenGaku(null == result.getKogakuJuryoininKeiyakuJigyosha().get利用者負担上限額() ? 空白
                        : SanteiKijungaku.toValue(new RString(result.getKogakuJuryoininKeiyakuJigyosha().get利用者負担上限額().toString()))
                        .get略称().replace(円単位, 空白));
                row.setRiyu(result.getKogakuJuryoininKeiyakuJigyosha().get不承認理由());
                rowList.add(row);
            }
        }
        グリッドに並び順を設定する(rowList);
        div.getDvHaraiKetteiToroku().getDgHaraiKettei().setDataSource(rowList);
    }

    private void グリッドに並び順を設定する(List<dgHaraiKettei_Row> rowList) {
        Collections.sort(rowList, new Comparator<dgHaraiKettei_Row>() {
            @Override
            public int compare(dgHaraiKettei_Row row1, dgHaraiKettei_Row row2) {
                return Integer.parseInt(row2.getRirekiNo().toString()) - Integer.parseInt(row1.getRirekiNo().toString());
            }
        });
    }

    private void 登録パネルに項目をクリアする() {
        div.getDvHaraiKetteiShusei().getBtnShinseiDate().clearValue();
        div.getDvHaraiKetteiShusei().getTxtUketsukeDate().clearValue();
        div.getDvHaraiKetteiShusei().getBtnKetteiDate().clearValue();
        div.getDvHaraiKetteiShusei().getBtnShoninDate().clearFromValue();
        div.getDvHaraiKetteiShusei().getBtnShoninDate().clearToValue();
        div.getDvHaraiKetteiShusei().getCcdJigyosha().initialize();
        div.getDvHaraiKetteiShusei().getCcdJigyosha().setNyuryokuShisetsuKodo(空白);
        div.getDvHaraiKetteiShusei().getRadKetteiKubun().setSelectedKey(KEY_決定区分_承認する);
        onChange_radKetteiKubun();
    }

    /**
     * 決定区分の変更を処理します。
     */
    public void onChange_radKetteiKubun() {
        RString selectKey = div.getDvHaraiKetteiShusei().getRadKetteiKubun().getSelectedKey();
        boolean is承認する = (!RString.isNullOrEmpty(selectKey)) && KEY_決定区分_承認する.equals(selectKey);
        div.getDvHaraiKetteiShusei().getTxtShoninShinaiRiyu().setDisabled(is承認する);
        if (is承認する) {
            div.getDvHaraiKetteiShusei().getTxtShoninShinaiRiyu().clearValue();
        }
        div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().setDataSource(!is承認する ? new ArrayList<KeyValueDataSource>()
                : get利用者負担上限額DataSource());
        div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().setDisabled(!is承認する);
        if (is承認する) {
            div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().setSelectedIndex(0);
        }
    }

    private List<KeyValueDataSource> get利用者負担上限額DataSource() {
        List<KeyValueDataSource> kvDataSource = new ArrayList<>();
        for (SanteiKijungaku santeiKijungaku : SanteiKijungaku.values()) {
            kvDataSource.add(new KeyValueDataSource(santeiKijungaku.getコード(), santeiKijungaku.get略称()));
        }
        return kvDataSource;
    }

    private RString get利用者負担上限額Key(RString 略称) {
        List<KeyValueDataSource> 利用者負担上限額DataSource = get利用者負担上限額DataSource();
        for (KeyValueDataSource keyValue : 利用者負担上限額DataSource) {
            if (略称.equals(keyValue.getValue())) {
                return keyValue.getKey();
            }
        }
        return 空白;
    }

    /**
     * 高額サービス費等受領委任払管理一覧グリッド 「修正」ボタンを処理します。
     */
    public void onClick_dgModify() {
        div.setOperateState(修正);
        登録パネルに項目をクリアする();
        グリッドから登録パネルに項目を表示する();
        登録パネルに項目の制御を設定する();
    }

    private void グリッドから登録パネルに項目を表示する() {
        dgHaraiKettei_Row row = div.getDvHaraiKetteiToroku().getDgHaraiKettei().getClickedItem();
        if (null != row.getShinseiDate().getValue() && (!FlexibleDate.EMPTY.equals(row.getShinseiDate().getValue()))) {
            div.getBtnShinseiDate().setValue(new RDate(row.getShinseiDate().getValue().toString()));
        }
        if (null != row.getUketsukeDate().getValue() && (!FlexibleDate.EMPTY.equals(row.getUketsukeDate().getValue()))) {
            div.getTxtUketsukeDate().setValue(new RDate(row.getUketsukeDate().getValue().toString()));
        }
        if (null != row.getKetteiDate().getValue() && (!FlexibleDate.EMPTY.equals(row.getKetteiDate().getValue()))) {
            div.getBtnKetteiDate().setValue(new RDate(row.getKetteiDate().getValue().toString()));
        }
        if (null != row.getShoninStartDate().getValue() && (!FlexibleDate.EMPTY.equals(row.getShoninStartDate().getValue()))) {
            div.getBtnShoninDate().setFromValue(new RDate(row.getShoninStartDate().getValue().toString()));
        }
        if (null != row.getShoninEndDate().getValue() && (!FlexibleDate.EMPTY.equals(row.getShoninEndDate().getValue()))) {
            div.getBtnShoninDate().setToValue(new RDate(row.getShoninEndDate().getValue().toString()));
        }
        div.getCcdJigyosha().setNyuryokuShisetsuKodo(row.getJigyoshaNo());
        div.getRadKetteiKubun().setSelectedKey(ShoninKubun.承認する.get名称().equals(row.getKetteiKubun())
                ? KEY_決定区分_承認する : KEY_決定区分_承認しない);
        onChange_radKetteiKubun();
        div.getTxtShoninShinaiRiyu().setValue(RString.isNullOrEmpty(row.getRiyu()) ? 空白 : row.getRiyu());

        if (!RString.isNullOrEmpty(row.getJogenGaku())) {
            RString 上限額 = row.getJogenGaku().concat(円単位);
            KeyValueDataSource kvDataSource = new KeyValueDataSource(SanteiKijungaku.toValue(get利用者負担上限額Key(上限額)).getコード(),
                    SanteiKijungaku.toValue(get利用者負担上限額Key(上限額)).get略称());
            List<KeyValueDataSource> kvDataSourceList = div.getDdlRiyoshafutanJogenGaku().getDataSource();
            if (null == kvDataSourceList || kvDataSourceList.isEmpty() || (!kvDataSourceList.contains(kvDataSource))) {
                div.getDdlRiyoshafutanJogenGaku().getDataSource().add(kvDataSource);
            }
            div.getDdlRiyoshafutanJogenGaku().setSelectedKey(get利用者負担上限額Key(上限額));
        }
        if (!追加.equals(div.getOperateState())) {
            div.getDvHaraiKetteiShusei().getTxtRirekiNo().setValue(RString.isNullOrEmpty(row.getRirekiNo()) ? 空白 : row.getRirekiNo());
        }
    }

    private void 登録パネルに項目の制御を設定する() {
        boolean is削除状態 = 削除.equals(div.getOperateState());
        div.getBtnShinseiDate().setDisabled(is削除状態);
        div.getTxtUketsukeDate().setDisabled(is削除状態);
        div.getBtnKetteiDate().setDisabled(is削除状態);
        div.getBtnShoninDate().setDisabled(is削除状態);
        div.getCcdJigyosha().setDisabled(is削除状態);
        if (is削除状態) {
            div.getRadKetteiKubun().setDisabled(is削除状態);
            div.getTxtShoninShinaiRiyu().setDisabled(is削除状態);
            div.getDdlRiyoshafutanJogenGaku().setDisabled(is削除状態);
        }
    }

    /**
     * 高額サービス費等受領委任払管理一覧グリッド 「削除」ボタンの変更を処理します。
     */
    public void onClick_dgDelete() {
        div.setOperateState(削除);
        登録パネルに項目をクリアする();
        グリッドから登録パネルに項目を表示する();
        登録パネルに項目の制御を設定する();
    }

    /**
     * ｢世帯一覧を表示する｣ボタンの変更を処理します。
     *
     * @param 引き継ぎデータ 引き継ぎデータ
     * @return KogakuServiceData
     */
    public KogakuServiceData onClick_btnSeitaiIchiran(TaishoshaKey 引き継ぎデータ) {
        KogakuServiceData 引き継ぎ情報 = new KogakuServiceData();
        引き継ぎ情報.set被保険者番号(new HihokenshaNo(div.getCddShikakuKihon().get被保険者番号()));
        引き継ぎ情報.setサービス提供年月(FlexibleDate.getNowDate().getYearMonth());
        引き継ぎ情報.set履歴番号(null);
        引き継ぎ情報.set証記載保険者番号(HokenshaNo.EMPTY);
        引き継ぎ情報.set識別コード(引き継ぎデータ.get識別コード());
        return 引き継ぎ情報;
    }

    /**
     * 「決定一覧へ戻る」ボタンを処理します。
     *
     * @return boolean
     */
    public boolean onClick_btnKetteiIchiranBack() {
        return !is画面内容変更_修正();
    }

    private boolean is画面内容変更_修正() {
        dgHaraiKettei_Row row = div.getDvHaraiKetteiToroku().getDgHaraiKettei().getClickedItem();
        return getRStringByRDate(div.getBtnShinseiDate().getValue()).equals(getRStringByFlexibleDate(row.getShinseiDate().getValue()))
                && getRStringByRDate(div.getTxtUketsukeDate().getValue()).equals(getRStringByFlexibleDate(row.getUketsukeDate().getValue()))
                && getRStringByRDate(div.getBtnKetteiDate().getValue()).equals(getRStringByFlexibleDate(row.getKetteiDate().getValue()))
                && getRStringByRDate(div.getBtnShoninDate().getFromValue()).equals(getRStringByFlexibleDate(row.getShoninStartDate().getValue()))
                && getRStringByRDate(div.getBtnShoninDate().getToValue()).equals(getRStringByFlexibleDate(row.getShoninEndDate().getValue()))
                && div.getCcdJigyosha().getNyuryokuShisetsuKodo().equals(row.getJigyoshaNo())
                && div.getRadKetteiKubun().getSelectedValue().equals(
                        RString.isNullOrEmpty(row.getKetteiKubun()) ? 空白 : row.getKetteiKubun())
                && (div.getTxtShoninShinaiRiyu().isDisabled() || div.getTxtShoninShinaiRiyu().getValue().equals(row.getRiyu()))
                && (div.getDdlRiyoshafutanJogenGaku().isDisabled()
                || div.getDdlRiyoshafutanJogenGaku().getSelectedValue().equals(
                        RString.isNullOrEmpty(row.getJogenGaku()) ? 空白 : row.getJogenGaku().concat(円単位)));
    }

    private RString getRStringByRDate(RDate date) {
        if (null != date) {
            return new RString(date.toString());
        }
        return 空白;
    }

    private RString getRStringByFlexibleDate(FlexibleDate date) {
        if (null != date && (!FlexibleDate.EMPTY.equals(date))) {
            return new RString(date.toString());
        }
        return 空白;
    }

    /**
     * 登録の場合　かつ　データの変更がある
     *
     * @param state RString
     * @return boolean
     */
    public boolean onClick_btnShuseiBack(RString state) {
        if (追加.equals(state)) {
            return !isデータの変更がなし_追加();
        }
        return false;
    }

    private boolean isデータの変更がなし_追加() {
        return null == div.getDvHaraiKetteiShusei().getBtnShinseiDate().getValue()
                && null == div.getDvHaraiKetteiShusei().getTxtUketsukeDate().getValue()
                && null == div.getDvHaraiKetteiShusei().getBtnKetteiDate().getValue()
                && null == div.getBtnShoninDate().getFromValue()
                && null == div.getBtnShoninDate().getToValue()
                && 空白.equals(div.getCcdJigyosha().getNyuryokuShisetsuKodo())
                && KEY_決定区分_承認する.equals(div.getRadKetteiKubun().getSelectedKey())
                && div.getTxtShoninShinaiRiyu().isDisabled()
                && 空白.equals(div.getDdlRiyoshafutanJogenGaku().getSelectedValue());
    }

    /**
     * 「保存する」ボタン押下前に入力チェックを処理します。
     *
     * @return boolean
     */
    public boolean onClick_btnSaveBefore() {
        return 修正.equals(div.getOperateState()) && is画面内容変更_修正();
    }

    /**
     * 「保存する」ボタンを処理します。
     *
     * @param holder KogakuJuryoininKeiyakuJigyoshaHolder
     */
    public void onClick_btnSave(KogakuJuryoininKeiyakuJigyoshaHolder holder) {
        List<KogakuJuryoininKeiyakuJigyosha> businessList = new ArrayList<>();
        if (追加.equals(div.getOperateState())) {
            KogakuJuryoininKeiyakuJigyosha business = getBusinessBy追加(holder);
            businessList.add(business);
            div.getDvHaraiKetteiShusei().getTxtRirekiNo().setValue(new RString(business.get履歴番号()));
        }
        if (修正.equals(div.getOperateState())) {
            KogakuJuryoininKeiyakuJigyosha business = getBusinessBy修正(holder);
            businessList.add(business.modified());
        }
        if (削除.equals(div.getOperateState())) {
            KogakuJuryoininKeiyakuJigyosha business = holder.getKogakuJuryoininKeiyakuJigyosha(
                    new KogakuJuryoininKeiyakuJigyoshaIdentifier(new HihokenshaNo(div.getCddShikakuKihon().get被保険者番号().toString()),
                            Integer.parseInt(div.getDvHaraiKetteiShusei().getTxtRirekiNo().getValue().toString()))).deleted();
            businessList.add(business);
        }
        boolean isSuccess = false;
        if (!businessList.isEmpty()) {
            KogakuJuryoininKeiyakuJigyoshaManager manager = new KogakuJuryoininKeiyakuJigyoshaManager();
            isSuccess = manager.saveOrDeletePhysical高額受領委任契約事業者(businessList.get(0));
        }
        div.getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                div.getCddAtenaInfo().getAtenaInfoDiv().getHdnTxtShikibetsuCode(), div.getCddAtenaInfo().get氏名漢字(), isSuccess);
        div.getDvKakuninsho().setVisible(!削除.equals(div.getOperateState()));
    }

    private KogakuJuryoininKeiyakuJigyosha getBusinessBy修正(KogakuJuryoininKeiyakuJigyoshaHolder holder) {
        return holder.getKogakuJuryoininKeiyakuJigyosha(
                new KogakuJuryoininKeiyakuJigyoshaIdentifier(new HihokenshaNo(div.getCddShikakuKihon().get被保険者番号().toString()),
                        Integer.parseInt(div.getDvHaraiKetteiShusei().getTxtRirekiNo().getValue().toString()))).createBuilderForEdit()
                .set申請年月日(null == div.getDvHaraiKetteiShusei().getBtnShinseiDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnShinseiDate().getValue().toString()))
                .set決定年月日(null == div.getDvHaraiKetteiShusei().getBtnKetteiDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnKetteiDate().getValue().toString()))
                .set受付年月日(null == div.getDvHaraiKetteiShusei().getTxtUketsukeDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getTxtUketsukeDate().getValue().toString()))
                .set受領委任払適用開始年月日(null == div.getDvHaraiKetteiShusei().getBtnShoninDate().getFromValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnShoninDate().getFromValue().toString()))
                .set受領委任払適用終了年月日(null == div.getDvHaraiKetteiShusei().getBtnShoninDate().getToValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnShoninDate().getToValue().toString()))
                .set事業者番号(RString.isNullOrEmpty(div.getDvHaraiKetteiShusei().getCcdJigyosha().getNyuryokuShisetsuKodo()) ? JigyoshaNo.EMPTY
                        : new JigyoshaNo(div.getDvHaraiKetteiShusei().getCcdJigyosha().getNyuryokuShisetsuKodo().toString()))
                .set承認結果区分(KEY_決定区分_承認する.equals(div.getDvHaraiKetteiShusei().getRadKetteiKubun().getSelectedKey())
                        ? ShoninKubun.承認する.getコード() : ShoninKubun.承認しない.getコード())
                .set不承認理由(div.getDvHaraiKetteiShusei().getTxtShoninShinaiRiyu().getValue())
                .set利用者負担上限額(RString.isNullOrEmpty(div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().getSelectedKey())
                        ? null : new Decimal(div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().getSelectedKey().toString()))
                .set契約番号(get契約番号(holder))
                .build();
    }

    private KogakuJuryoininKeiyakuJigyosha getBusinessBy追加(KogakuJuryoininKeiyakuJigyoshaHolder holder) {
        int 履歴番号MAX = 0;
        List<KogakuJuryoininKeiyakuJigyosha> businessList = new ArrayList<>();
        if (null != holder && null != holder.getKogakuJuryoininKeiyakuJigyoshaList()
                && (!holder.getKogakuJuryoininKeiyakuJigyoshaList().isEmpty())) {
            businessList = holder.getKogakuJuryoininKeiyakuJigyoshaList();
        }
        if (!businessList.isEmpty()) {
            for (KogakuJuryoininKeiyakuJigyosha business : businessList) {
                if (履歴番号MAX < business.get履歴番号()) {
                    履歴番号MAX = business.get履歴番号();
                }
            }
        }
        return new KogakuJuryoininKeiyakuJigyosha(
                new HihokenshaNo(div.getCddShikakuKihon().get被保険者番号().toString()),
                履歴番号MAX + 1).createBuilderForEdit()
                .set申請年月日(null == div.getDvHaraiKetteiShusei().getBtnShinseiDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnShinseiDate().getValue().toString()))
                .set受付年月日(null == div.getDvHaraiKetteiShusei().getTxtUketsukeDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getTxtUketsukeDate().getValue().toString()))
                .set決定年月日(null == div.getDvHaraiKetteiShusei().getBtnKetteiDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnKetteiDate().getValue().toString()))
                .set受領委任払適用終了年月日(null == div.getDvHaraiKetteiShusei().getBtnShoninDate().getToValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnShoninDate().getToValue().toString()))
                .set受領委任払適用開始年月日(null == div.getDvHaraiKetteiShusei().getBtnShoninDate().getFromValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHaraiKetteiShusei().getBtnShoninDate().getFromValue().toString()))
                .set事業者番号(RString.isNullOrEmpty(div.getDvHaraiKetteiShusei().getCcdJigyosha().getNyuryokuShisetsuKodo()) ? JigyoshaNo.EMPTY
                        : new JigyoshaNo(div.getDvHaraiKetteiShusei().getCcdJigyosha().getNyuryokuShisetsuKodo().toString()))
                .set承認結果区分(KEY_決定区分_承認する.equals(div.getDvHaraiKetteiShusei().getRadKetteiKubun().getSelectedKey())
                        ? ShoninKubun.承認する.getコード() : ShoninKubun.承認しない.getコード())
                .set利用者負担上限額(RString.isNullOrEmpty(div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().getSelectedKey())
                        ? null : new Decimal(div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku().getSelectedKey().toString()))
                .set不承認理由(div.getDvHaraiKetteiShusei().getTxtShoninShinaiRiyu().getValue())
                .set契約番号(get契約番号(holder))
                .set承認結果通知書作成日(FlexibleDate.EMPTY)
                .set承認結果通知書再発行区分(空白)
                .build();
    }

    private RString get契約番号(KogakuJuryoininKeiyakuJigyoshaHolder holder) {
        int year = div.getDvHaraiKetteiShusei().getBtnShoninDate().getFromValue().getYearValue();
        if (null == holder || null == holder.getKogakuJuryoininKeiyakuJigyoshaList()
                || holder.getKogakuJuryoininKeiyakuJigyoshaList().isEmpty()) {
            return new RString(year).concat(ONE_契約番号下四桁);
        }
        List<KogakuJuryoininKeiyakuJigyosha> businessList = holder.getKogakuJuryoininKeiyakuJigyoshaList();
        RString 契約番号下四桁 = ZERO_契約番号下四桁;
        if (!RString.isNullOrEmpty(businessList.get(0).get契約番号())) {
            契約番号下四桁 = businessList.get(0).get契約番号().substring(LENGTH_契約番号西暦年度, LENGTH_契約番号);
        }
        for (KogakuJuryoininKeiyakuJigyosha business : businessList) {
            if (!RString.isNullOrEmpty(business.get契約番号())) {
                RString temp契約番号下四桁 = business.get契約番号().substring(LENGTH_契約番号西暦年度, LENGTH_契約番号);
                if (Integer.parseInt(契約番号下四桁.toString()) < Integer.parseInt(temp契約番号下四桁.toString())) {
                    契約番号下四桁 = temp契約番号下四桁;
                }
            }
        }
        RString new契約番号下四桁 = new RString(Integer.parseInt(契約番号下四桁.toString()) + 1);
        int i = new契約番号下四桁.length();
        for (; i < LENGTH_契約番号下四桁; i++) {
            new契約番号下四桁 = ZERO.concat(new契約番号下四桁);
        }
        return new RString(year).concat(new契約番号下四桁);
    }

    /**
     * 「発行する」ボタンを処理します。
     *
     * @param holder KogakuJuryoininKeiyakuJigyoshaHolder
     * @return result KogakuServiceHiJuryoininKeiyakuKakuninshoResult
     */
    public KogakuServiceHiJuryoininKeiyakuKakuninshoResult onClick_btnHakko(KogakuJuryoininKeiyakuJigyoshaHolder holder) {
        KogakuJuryoininKeiyakuJigyosha newBusiness = holder.getKogakuJuryoininKeiyakuJigyosha(
                new KogakuJuryoininKeiyakuJigyoshaIdentifier(new HihokenshaNo(div.getCddShikakuKihon().get被保険者番号().toString()),
                        Integer.parseInt(div.getDvHaraiKetteiShusei().getTxtRirekiNo().getValue().toString()))).createBuilderForEdit()
                .set承認結果通知書作成日(null == div.getDvHakko().getTxtTsuchiDate().getValue() ? FlexibleDate.EMPTY
                        : new FlexibleDate(div.getDvHakko().getTxtTsuchiDate().getValue().toString()))
                .build();
        KogakuJuryoininKeiyakuJigyoshaManager manager = new KogakuJuryoininKeiyakuJigyoshaManager();
        if (null != newBusiness) {
            manager.saveOrDeletePhysical高額受領委任契約事業者(newBusiness);
            KogakuServiceHiJuryoininKeiyakuKakuninsho 帳票発行処理Business = KogakuServiceHiJuryoininKeiyakuKakuninsho.createInstance();
            return 帳票発行処理Business.getKogakuServiceHiJuryoininKeiyakuKakuninshoData(getParameter(newBusiness));
        }
        return new KogakuServiceHiJuryoininKeiyakuKakuninshoResult();
    }

    private KogakuServiceHiJuryoininKeiyakuKakuninshoParameter getParameter(KogakuJuryoininKeiyakuJigyosha business) {
        KogakuServiceHiJuryoininKeiyakuKakuninshoParameter param = new KogakuServiceHiJuryoininKeiyakuKakuninshoParameter();
        param.set識別コード(div.getDvKyotsuJoho().getCddAtenaInfo().getShokaiData().getTxtShikibetsuCode().getDomain());
        param.set被保険者番号(business.get被保険者番号());
        param.set被保険者氏名(div.getDvKyotsuJoho().getCddAtenaInfo().get氏名漢字());
        param.set被保険者氏名フリガナ(div.getDvKyotsuJoho().getCddAtenaInfo().get氏名カナ());
        param.set申請日(business.get申請年月日());
        param.set受付日(business.get受付年月日());
        param.set決定日(business.get決定年月日());
        param.set承認開始日(business.get受領委任払適用開始年月日());
        param.set承認終了日(business.get受領委任払適用終了年月日());
        param.set事業者番号(business.get事業者番号().value());
        param.set決定区分(business.get承認結果区分());
        param.set承認しない理由(RString.isNullOrEmpty(business.get不承認理由()) ? 空白 : business.get不承認理由());
        param.set利用者負担上限額(null == business.get利用者負担上限額() ? null
                : SanteiKijungaku.toValue(new RString(business.get利用者負担上限額().intValue())).get略称());
        param.set通知日(new FlexibleDate(div.getDvKakuninsho().getTxtTsuchiDate().getValue().toString()));
        param.set文書番号(div.getDvKakuninsho().getCcdBunshoBango().get文書番号());
        return param;
    }
}
