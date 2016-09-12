/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinBetsuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTanka;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.HomonShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinShubetsu;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.HoshuMasutaKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgChosainhoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgHomonChosahoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgIkenShohoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgShinsakaiIinBetuTanka_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 報酬マスタメンテナンス画面のHandlerクラスです。
 *
 * @reamsid_L DBE-1710-010 dingyi
 */
public class HoshuMasutaKoshinHandler {

    private final HoshuMasutaKoshinDiv div;
    private final RString 追加モード = new RString("追加");
    private final RString 更新モード = new RString("修正");
    private final RString 削除モード = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 報酬マスタメンテナンスDiv
     */
    public HoshuMasutaKoshinHandler(HoshuMasutaKoshinDiv div) {
        this.div = div;
    }

    /**
     * 報酬マスタメンテナンス画面の初期化処理です。
     *
     * @param 審査員報酬単価マスタ情報 審査員報酬単価マスタ情報
     */
    public void onLoad(List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ情報) {
        set審査員報酬単価一覧情報(審査員報酬単価マスタ情報);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabChosainhoshuTanka());
    }

    /**
     * 意見書報酬単価マスタタブを選択する画面の初期化処理です。
     *
     * @param 意見書報酬単価マスタ情報 意見書報酬単価マスタ情報
     */
    public void set意見書報酬単価マスタタブ(List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ情報) {
        set意見書報酬単価一覧情報(意見書報酬単価マスタ情報);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTblIkenShohoshuTanka());
    }

    /**
     * 訪問調査報酬単価マスタタブを選択する画面の初期化処理です。
     *
     * @param 訪問調査報酬単価マスタ情報 訪問調査報酬単価マスタ情報
     */
    public void set訪問調査報酬単価マスタタブ(List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ情報) {
        set訪問調査報酬単価一覧情報(訪問調査報酬単価マスタ情報);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHomonChosahoshuTanka());
    }

    /**
     * 審査会委員別単価マスタを選択する画面の初期化処理です。
     *
     * @param 審査会委員別単価マスタ情報 審査会委員別単価マスタ情報
     */
    public void set審査会委員別単価マスタタブ(List<ShinsakaiIinBetsuTanka> 審査会委員別単価マスタ情報) {
        set審査会委員別単価一覧情報(審査会委員別単価マスタ情報);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTbShinsakaiIinBetuTanka());
    }

    /**
     * 審査員報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     */
    public void onClick_btnChoTsuika() {
        set審査員報酬単価マスタ明細状態_活性();
        set審査員報酬DDL();
        div.getHoshuMasutaTab().getTxtChoKaishiYM().clearDomain();
        div.getHoshuMasutaTab().getTxtChoShuryoYM().clearDomain();
        div.getHoshuMasutaTab().getTxtChoTanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDdlKaigoNinteiShinsaIinShubetsu().
                setSelectedKey(ShinsakaiIinShubetsu.委員.getコード());
        div.setChosainhoshuTankaState(追加モード);
    }

    /**
     * 審査員報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の審査委員報酬単価情報 選択行の審査委員報酬単価情報
     */
    public void onSelect_btnChosainModify(dgChosainhoshuTankaIchiran_Row 選択行の審査委員報酬単価情報) {
        set審査員報酬単価マスタ明細状態_活性();
        set審査員報酬DDL();
        set審査員報酬単価マスタ明細内容(選択行の審査委員報酬単価情報);
        div.getHoshuMasutaTab().getTxtChoKaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getTxtChoShuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().setDisabled(true);
        div.setChosainhoshuTankaState(更新モード);
    }

    /**
     * 審査員報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の審査委員報酬単価情報 選択行の審査委員報酬単価情報
     */
    public void onSelect_btnChosainDelete(dgChosainhoshuTankaIchiran_Row 選択行の審査委員報酬単価情報) {
        set審査員報酬DDL();
        set審査員報酬単価マスタ明細内容(選択行の審査委員報酬単価情報);
        set審査員報酬単価マスタ明細状態_非活性();
        div.setChosainhoshuTankaState(削除モード);
    }

    /**
     * 審査員報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     */
    public void onClick_btnChoTorikesu() {
        set審査員報酬DDL();
        div.getHoshuMasutaTab().getTxtChoKaishiYM().clearDomain();
        div.getHoshuMasutaTab().getTxtChoShuryoYM().clearDomain();
        div.getHoshuMasutaTab().getTxtChoTanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDdlKaigoNinteiShinsaIinShubetsu().
                setSelectedKey(ShinsakaiIinShubetsu.委員.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabChosainhoshuTanka());
    }

    /**
     * 審査員報酬単価マスタ更新するボタンを押下するの場合、審査員報酬単価マスタ一覧を更新します。
     */
    public void onClick_btnChoKousin() {
        RString 処理モード = div.getChosainhoshuTankaState();
        List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報
                = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getDataSource();
        dgChosainhoshuTankaIchiran_Row 選択したデータ
                = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getActiveRow();
        if (追加モード.equals(処理モード)) {
            dgChosainhoshuTankaIchiran_Row 新規データ = new dgChosainhoshuTankaIchiran_Row();
            新規データ.setColumnState(追加モード);
            新規データ.getKaishiYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtChoKaishiYM().getDomain().toDateString()));
            新規データ.getShuryoYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtChoShuryoYM().getDomain().toDateString()));
            新規データ.setKaigoNinteiShinsaIinShubetsu(div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedValue());
            新規データ.setKaigoNinteiShinsaIinShubetsuCode(div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey());
            新規データ.getTanka().setValue(div.getHoshuMasutaTab().getTxtChoTanka().getValue());
            審査員報酬単価一覧情報.add(新規データ);
            Collections.sort(審査員報酬単価一覧情報, new DateComparatorChosainhoshu());
        } else if (更新モード.equals(処理モード)) {
            if (isデータ変更(選択したデータ) && !追加モード.equals(選択したデータ.getColumnState())) {
                選択したデータ.setColumnState(更新モード);
            }
            if (isデータ変更(選択したデータ)) {
                選択したデータ.getKaishiYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtChoKaishiYM().getDomain().toDateString()));
                選択したデータ.getShuryoYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtChoShuryoYM().getDomain().toDateString()));
                選択したデータ.setKaigoNinteiShinsaIinShubetsu(div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedValue());
                選択したデータ.setKaigoNinteiShinsaIinShubetsuCode(div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey());
                選択したデータ.getTanka().setValue(div.getHoshuMasutaTab().getTxtChoTanka().getValue());
            }
        } else if (削除モード.equals(処理モード)) {
            if (追加モード.equals(選択したデータ.getColumnState())) {
                審査員報酬単価一覧情報.remove(選択したデータ);
            } else {
                選択したデータ.setColumnState(削除モード);
            }
        }
    }

    /**
     * 意見書報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     */
    public void onClick_btnIkenTsuika() {
        set意見書報酬単価マスタ明細状態_活性();
        set意見書報酬DDL();
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().clearDomain();
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().clearDomain();
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getIkenShohoshuTankaNyuryoku().
                getDdlIkenshoSakuseiKaisuKubun().setSelectedKey(IkenshoSakuseiKaisuKubun.初回.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getIkenShohoshuTankaNyuryoku().
                getDdlZaitakuShisetsuKubun().setSelectedKey(ZaitakuShisetsuKubun.在宅.getコード());
        div.setIkenShohoshuTankaState(追加モード);
    }

    /**
     * 意見書報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の意見書報酬単価情報 選択行の意見書報酬単価情報
     */
    public void onSelect_btnIkenShoModify(dgIkenShohoshuTankaIchiran_Row 選択行の意見書報酬単価情報) {
        set意見書報酬単価マスタ明細状態_活性();
        set意見書報酬DDL();
        set意見書報酬単価マスタ明細内容(選択行の意見書報酬単価情報);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().setDisabled(true);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().setDisabled(true);
        div.setIkenShohoshuTankaState(更新モード);
    }

    /**
     * 意見書報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の意見書報酬単価情報 選択行の意見書報酬単価情報
     */
    public void onSelect_btnIkenShoDelete(dgIkenShohoshuTankaIchiran_Row 選択行の意見書報酬単価情報) {
        set意見書報酬DDL();
        set意見書報酬単価マスタ明細内容(選択行の意見書報酬単価情報);
        set意見書報酬単価マスタ明細状態_非活性();
        div.setIkenShohoshuTankaState(削除モード);
    }

    /**
     * 意見書報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     */
    public void onClick_btnIkenTorikesu() {
        set意見書報酬DDL();
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().clearDomain();
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().clearDomain();
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getIkenShohoshuTankaNyuryoku().
                getDdlIkenshoSakuseiKaisuKubun().setSelectedKey(IkenshoSakuseiKaisuKubun.初回.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getIkenShohoshuTankaNyuryoku().
                getDdlZaitakuShisetsuKubun().setSelectedKey(ZaitakuShisetsuKubun.在宅.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTblIkenShohoshuTanka());
    }

    /**
     * 意見書報酬単価マスタ更新するボタンを押下するの場合、意見書報酬単価マスタ一覧を更新します。
     */
    public void onClick_btnIkenKousin() {
        RString 処理モード = div.getIkenShohoshuTankaState();
        List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報
                = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getDataSource();
        dgIkenShohoshuTankaIchiran_Row 選択したデータ
                = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getActiveRow();
        if (追加モード.equals(処理モード)) {
            dgIkenShohoshuTankaIchiran_Row 新規データ = new dgIkenShohoshuTankaIchiran_Row();
            新規データ.setColumnState(追加モード);
            新規データ.getKaishiYM().setValue(new FlexibleDate(
                    div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().getDomain().toDateString()));
            新規データ.getShuryoYM().setValue(new FlexibleDate(
                    div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().getDomain().toDateString()));
            新規データ.setZaitakuShisetsuKubun(
                    div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedValue());
            新規データ.setZaitakuShisetsuKubunCode(
                    div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey());
            新規データ.setIkenshoSakuseiKaisuKubun(
                    div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedValue());
            新規データ.setIkenshoSakuseiKaisuKubunCode(
                    div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey());
            新規データ.getTanka().setValue(div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().getValue());
            意見書報酬単価一覧情報.add(新規データ);
            Collections.sort(意見書報酬単価一覧情報, new DateComparatorIkenSho());
        } else if (更新モード.equals(処理モード)) {
            if (isデータ変更(選択したデータ) && !追加モード.equals(選択したデータ.getColumnState())) {
                選択したデータ.setColumnState(更新モード);
            }
            if (isデータ変更(選択したデータ)) {
                選択したデータ.getKaishiYM().setValue(new FlexibleDate(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().getDomain().toDateString()));
                選択したデータ.getShuryoYM().setValue(new FlexibleDate(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().getDomain().toDateString()));
                選択したデータ.setZaitakuShisetsuKubun(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedValue());
                選択したデータ.setZaitakuShisetsuKubunCode(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey());
                選択したデータ.setIkenshoSakuseiKaisuKubun(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedValue());
                選択したデータ.setIkenshoSakuseiKaisuKubunCode(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey());
                選択したデータ.getTanka().setValue(div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().getValue());
            }
        } else if (削除モード.equals(処理モード)) {
            if (追加モード.equals(選択したデータ.getColumnState())) {
                意見書報酬単価一覧情報.remove(選択したデータ);
            } else {
                選択したデータ.setColumnState(削除モード);
            }
        }
    }

    /**
     * 訪問調査報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     */
    public void onClick_btnHomTsuika() {
        set訪問調査報酬単価マスタ明細状態_活性();
        set訪問調査報酬DDL();
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().clearDomain();
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().clearDomain();
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getHomonChosahoshuTankaNyuryoku().
                getDdlChosaKubun().setSelectedKey(ChosaKubun.新規調査.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getHomonChosahoshuTankaNyuryoku().
                getDdlHomonShubetsu().setSelectedKey(HomonShubetsu.在宅.getコード());
        div.setHomonChosahoshuTankaState(追加モード);
    }

    /**
     * 訪問調査報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の訪問調査報酬単価情報 選択行の訪問調査報酬単価情報
     */
    public void onSelect_btnHomonChosaModify(dgHomonChosahoshuTankaIchiran_Row 選択行の訪問調査報酬単価情報) {
        set訪問調査報酬単価マスタ明細状態_活性();
        set訪問調査報酬DDL();
        set訪問調査報酬単価マスタ明細内容(選択行の訪問調査報酬単価情報);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().setDisabled(true);
        div.setHomonChosahoshuTankaState(更新モード);
    }

    /**
     * 訪問調査報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の訪問調査報酬単価情報 選択行の訪問調査報酬単価情報
     */
    public void onSelect_btnHomonChosaDelete(dgHomonChosahoshuTankaIchiran_Row 選択行の訪問調査報酬単価情報) {
        set訪問調査報酬DDL();
        set訪問調査報酬単価マスタ明細内容(選択行の訪問調査報酬単価情報);
        set訪問調査報酬単価マスタ明細状態_非活性();
        div.setHomonChosahoshuTankaState(削除モード);
    }

    /**
     * 訪問調査報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     */
    public void onClick_btnHomTorikesu() {
        set訪問調査報酬DDL();
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().clearDomain();
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().clearDomain();
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getHomonChosahoshuTankaNyuryoku().
                getDdlChosaKubun().setSelectedKey(ChosaKubun.新規調査.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getHomonChosahoshuTankaNyuryoku().
                getDdlHomonShubetsu().setSelectedKey(HomonShubetsu.在宅.getコード());
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHomonChosahoshuTanka());
    }

    /**
     * 訪問調査報酬単価マスタ更新するボタンを押下するの場合、訪問調査報酬単価マスタ一覧を更新します。
     */
    public void onClick_btnHomKousin() {
        RString 処理モード = div.getHomonChosahoshuTankaState();
        List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報
                = div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getDataSource();
        dgHomonChosahoshuTankaIchiran_Row 選択したデータ
                = div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getActiveRow();
        if (追加モード.equals(処理モード)) {
            dgHomonChosahoshuTankaIchiran_Row 新規データ = new dgHomonChosahoshuTankaIchiran_Row();
            新規データ.setColumnState(追加モード);
            新規データ.getKaishiYM().setValue(new FlexibleDate(
                    div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().getDomain().toDateString()));
            新規データ.getShuryoYM().setValue(new FlexibleDate(
                    div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().getDomain().toDateString()));
            新規データ.setChosaKubun(
                    div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedValue());
            新規データ.setChosaKubunCode(
                    div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey());
            新規データ.setHomonShubetsu(
                    div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedValue());
            新規データ.setHomonShubetsuCode(
                    div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey());
            新規データ.getTanka().setValue(div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().getValue());
            訪問調査報酬単価一覧情報.add(新規データ);
            Collections.sort(訪問調査報酬単価一覧情報, new DateComparatorHomonChosa());
        } else if (更新モード.equals(処理モード)) {
            if (isデータ変更(選択したデータ) && !追加モード.equals(選択したデータ.getColumnState())) {
                選択したデータ.setColumnState(更新モード);
            }
            if (isデータ変更(選択したデータ)) {
                選択したデータ.getKaishiYM().setValue(new FlexibleDate(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().getDomain().toDateString()));
                選択したデータ.getShuryoYM().setValue(new FlexibleDate(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().getDomain().toDateString()));
                選択したデータ.setChosaKubun(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedValue());
                選択したデータ.setChosaKubunCode(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey());
                選択したデータ.setHomonShubetsu(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedValue());
                選択したデータ.setHomonShubetsuCode(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey());
                選択したデータ.getTanka().setValue(div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().getValue());
            }
        } else if (削除モード.equals(処理モード)) {
            if (追加モード.equals(選択したデータ.getColumnState())) {
                訪問調査報酬単価一覧情報.remove(選択したデータ);
            } else {
                選択したデータ.setColumnState(削除モード);
            }
        }
    }

    /**
     * 審査会委員別単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     */
    public void onClick_btnBetuTsuika() {
        set審査会委員別単価マスタ明細状態_活性();
        div.getHoshuMasutaTab().getTxtBetuKaishiYM().clearDomain();
        div.getHoshuMasutaTab().getTxtBetuShuryoYM().clearDomain();
        div.getHoshuMasutaTab().getTxtShinsaIinKodo().clearValue();
        div.getHoshuMasutaTab().getTxtBetuTanka().clearValue();
        div.getHoshuMasutaTab().getTxtBetuSonotaTanka().clearValue();
        div.setShinsakaiIinBetuTankaState(追加モード);
    }

    /**
     * 審査会委員別単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の審査会委員別単価情報 選択行の審査会委員別単価情報
     */
    public void onSelect_btnShinsakaiIinBetuModify(dgShinsakaiIinBetuTanka_Row 選択行の審査会委員別単価情報) {
        set審査会委員別単価マスタ明細状態_活性();
        set審査会委員別単価マスタ明細内容(選択行の審査会委員別単価情報);
        div.getHoshuMasutaTab().getTxtBetuKaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getTxtBetuShuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getTxtShinsaIinKodo().setDisabled(true);
        div.setShinsakaiIinBetuTankaState(更新モード);
    }

    /**
     * 審査会委員別単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param 選択行の審査会委員別単価情報 選択行の審査会委員別単価情報
     */
    public void onSelect_btnShinsakaiIinBetuDelete(dgShinsakaiIinBetuTanka_Row 選択行の審査会委員別単価情報) {
        set審査会委員別単価マスタ明細内容(選択行の審査会委員別単価情報);
        set審査会委員別単価マスタ明細状態_非活性();
        div.setShinsakaiIinBetuTankaState(削除モード);
    }

    /**
     * 審査会委員別単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     */
    public void onClick_btnBetuTorikesu() {
        div.getHoshuMasutaTab().getTxtBetuKaishiYM().clearDomain();
        div.getHoshuMasutaTab().getTxtBetuShuryoYM().clearDomain();
        div.getHoshuMasutaTab().getTxtShinsaIinKodo().clearValue();
        div.getHoshuMasutaTab().getTxtBetuTanka().clearValue();
        div.getHoshuMasutaTab().getTxtBetuSonotaTanka().clearValue();
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTbShinsakaiIinBetuTanka());
    }

    /**
     * 審査会委員別単価マスタ更新するボタンを押下するの場合、審査会委員別単価マスタ一覧を更新します。
     */
    public void onClick_btnBetuKousin() {
        RString 処理モード = div.getShinsakaiIinBetuTankaState();
        List<dgShinsakaiIinBetuTanka_Row> 審査会委員別単価マスタ一覧情報
                = div.getHoshuMasutaTab().getDgShinsakaiIinBetuTanka().getDataSource();
        dgShinsakaiIinBetuTanka_Row 選択したデータ
                = div.getHoshuMasutaTab().getDgShinsakaiIinBetuTanka().getActiveRow();
        if (追加モード.equals(処理モード)) {
            dgShinsakaiIinBetuTanka_Row 新規データ = new dgShinsakaiIinBetuTanka_Row();
            新規データ.setColumnState(追加モード);
            新規データ.getKaishiYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtBetuKaishiYM().getDomain().toDateString()));
            新規データ.getShuryoYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtBetuShuryoYM().getDomain().toDateString()));
            新規データ.setShinsakaiIinCode(div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue());
            新規データ.getTanka().setValue(div.getHoshuMasutaTab().getTxtBetuTanka().getValue());
            新規データ.getSonotaTanka().setValue(div.getHoshuMasutaTab().getTxtBetuSonotaTanka().getValue());
            審査会委員別単価マスタ一覧情報.add(新規データ);
            Collections.sort(審査会委員別単価マスタ一覧情報, new DateComparatorShinsakaiIinBetu());
        } else if (更新モード.equals(処理モード)) {
            if (isデータ変更(選択したデータ) && !追加モード.equals(選択したデータ.getColumnState())) {
                選択したデータ.setColumnState(更新モード);
            }
            if (isデータ変更(選択したデータ)) {
                選択したデータ.getKaishiYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtBetuKaishiYM().getDomain().toDateString()));
                選択したデータ.getShuryoYM().setValue(new FlexibleDate(div.getHoshuMasutaTab().getTxtBetuShuryoYM().getDomain().toDateString()));
                選択したデータ.setShinsakaiIinCode(div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue());
                選択したデータ.getTanka().setValue(div.getHoshuMasutaTab().getTxtBetuTanka().getValue());
                選択したデータ.getSonotaTanka().setValue(div.getHoshuMasutaTab().getTxtBetuSonotaTanka().getValue());
            }
        } else if (削除モード.equals(処理モード)) {
            if (追加モード.equals(選択したデータ.getColumnState())) {
                審査会委員別単価マスタ一覧情報.remove(選択したデータ);
            } else {
                選択したデータ.setColumnState(削除モード);
            }
        }
    }

    private void set審査員報酬単価一覧情報(List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ情報) {
        List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報 = new ArrayList<>();
        for (ShinsakaiIinHoshuTanka 審査員報酬単価 : 審査員報酬単価マスタ情報) {
            dgChosainhoshuTankaIchiran_Row row = new dgChosainhoshuTankaIchiran_Row();
            row.getKaishiYM().setValue(new FlexibleDate(審査員報酬単価.get開始年月().toDateString()));
            row.getShuryoYM().setValue(new FlexibleDate(審査員報酬単価.get終了年月().toDateString()));
            row.setKaigoNinteiShinsaIinShubetsu(ShinsakaiIinShubetsu.toValue(審査員報酬単価.get介護認定審査委員種別().value()).get名称());
            row.setKaigoNinteiShinsaIinShubetsuCode(審査員報酬単価.get介護認定審査委員種別().value());
            row.getTanka().setValue(審査員報酬単価.get単価());
            審査員報酬単価一覧情報.add(row);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgChosainhoshuTankaIchiran().setDataSource(審査員報酬単価一覧情報);
    }

    private void set審査員報酬DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ShinsakaiIinShubetsu 介護認定審査委員種別 : ShinsakaiIinShubetsu.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(介護認定審査委員種別.getコード());
            keyValue.setValue(介護認定審査委員種別.get名称());
            dataSource.add(keyValue);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDdlKaigoNinteiShinsaIinShubetsu().setDataSource(dataSource);
    }

    private void set意見書報酬単価一覧情報(List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ情報) {
        List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報 = new ArrayList<>();
        for (ShujiiIkenshoHoshuTanka 意見書報酬単価 : 意見書報酬単価マスタ情報) {
            dgIkenShohoshuTankaIchiran_Row row = new dgIkenShohoshuTankaIchiran_Row();
            row.getKaishiYM().setValue(new FlexibleDate(意見書報酬単価.get開始年月().toDateString()));
            row.getShuryoYM().setValue(new FlexibleDate(意見書報酬単価.get終了年月().toDateString()));
            row.setZaitakuShisetsuKubun(ZaitakuShisetsuKubun.toValue(意見書報酬単価.get在宅施設区分().getKey()).get名称());
            row.setZaitakuShisetsuKubunCode(意見書報酬単価.get在宅施設区分().getKey());
            row.setIkenshoSakuseiKaisuKubun(IkenshoSakuseiKaisuKubun.toValue(意見書報酬単価.get意見書作成回数区分().value()).get名称());
            row.setIkenshoSakuseiKaisuKubunCode(意見書報酬単価.get意見書作成回数区分().value());
            row.getTanka().setValue(意見書報酬単価.get単価());
            意見書報酬単価一覧情報.add(row);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgIkenShohoshuTankaIchiran().setDataSource(意見書報酬単価一覧情報);
    }

    private void set意見書報酬DDL() {
        List<KeyValueDataSource> 在宅施設区分List = new ArrayList<>();
        for (ZaitakuShisetsuKubun 在宅施設区分 : ZaitakuShisetsuKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(在宅施設区分.getコード());
            keyValue.setValue(在宅施設区分.get名称());
            在宅施設区分List.add(keyValue);
        }
        List<KeyValueDataSource> 意見書作成回数区分List = new ArrayList<>();
        for (IkenshoSakuseiKaisuKubun 意見書作成回数区分 : IkenshoSakuseiKaisuKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(意見書作成回数区分.getコード());
            keyValue.setValue(意見書作成回数区分.get名称());
            意見書作成回数区分List.add(keyValue);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getIkenShohoshuTankaNyuryoku().
                getDdlIkenshoSakuseiKaisuKubun().setDataSource(意見書作成回数区分List);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getIkenShohoshuTankaNyuryoku().
                getDdlZaitakuShisetsuKubun().setDataSource(在宅施設区分List);
    }

    private void set訪問調査報酬単価一覧情報(List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ情報) {
        List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報 = new ArrayList<>();
        for (NinteiChosaHoshuTanka 訪問調査報酬単価 : 訪問調査報酬単価マスタ情報) {
            dgHomonChosahoshuTankaIchiran_Row row = new dgHomonChosahoshuTankaIchiran_Row();
            row.getKaishiYM().setValue(new FlexibleDate(訪問調査報酬単価.get開始年月().toDateString()));
            row.getShuryoYM().setValue(new FlexibleDate(訪問調査報酬単価.get終了年月().toDateString()));
            row.setChosaKubun(ChosaKubun.toValue(訪問調査報酬単価.get調査区分().value()).get名称());
            row.setChosaKubunCode(訪問調査報酬単価.get調査区分().value());
            row.setHomonShubetsu(HomonShubetsu.toValue(訪問調査報酬単価.get訪問種別().value()).get名称());
            row.setHomonShubetsuCode(訪問調査報酬単価.get訪問種別().value());
            row.getTanka().setValue(訪問調査報酬単価.get単価());
            訪問調査報酬単価一覧情報.add(row);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgHomonChosahoshuTankaIchiran().setDataSource(訪問調査報酬単価一覧情報);
    }

    private void set訪問調査報酬DDL() {
        List<KeyValueDataSource> 調査区分List = new ArrayList<>();
        for (ChosaKubun 調査区分 : ChosaKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(調査区分.getコード());
            keyValue.setValue(調査区分.get名称());
            調査区分List.add(keyValue);
        }
        List<KeyValueDataSource> 訪問種別List = new ArrayList<>();
        for (HomonShubetsu 訪問種別 : HomonShubetsu.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(訪問種別.getコード());
            keyValue.setValue(訪問種別.get名称());
            訪問種別List.add(keyValue);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getHomonChosahoshuTankaNyuryoku().
                getDdlChosaKubun().setDataSource(調査区分List);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getHomonChosahoshuTankaNyuryoku().
                getDdlHomonShubetsu().setDataSource(訪問種別List);
    }

    private void set審査会委員別単価一覧情報(List<ShinsakaiIinBetsuTanka> 審査会委員別単価マスタ情報) {
        List<dgShinsakaiIinBetuTanka_Row> 審査会委員別単価一覧情報 = new ArrayList<>();
        for (ShinsakaiIinBetsuTanka 審査会委員別単価 : 審査会委員別単価マスタ情報) {
            dgShinsakaiIinBetuTanka_Row row = new dgShinsakaiIinBetuTanka_Row();
            row.getKaishiYM().setValue(new FlexibleDate(審査会委員別単価.get開始年月().toDateString()));
            row.getShuryoYM().setValue(new FlexibleDate(審査会委員別単価.get終了年月().toDateString()));
            row.setShinsakaiIinCode(審査会委員別単価.get介護認定審査会委員コード());
            row.getTanka().setValue(審査会委員別単価.get単価());
            row.getSonotaTanka().setValue(審査会委員別単価.getその他単価());
            審査会委員別単価一覧情報.add(row);
        }
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgShinsakaiIinBetuTanka().setDataSource(審査会委員別単価一覧情報);
    }

    private void set審査員報酬単価マスタ明細状態_非活性() {
        div.getHoshuMasutaTab().getTxtChoKaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getTxtChoShuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().setDisabled(true);
        div.getHoshuMasutaTab().getTxtChoTanka().setDisabled(true);
    }

    private void set審査員報酬単価マスタ明細状態_活性() {
        div.getHoshuMasutaTab().getTxtChoKaishiYM().setDisabled(false);
        div.getHoshuMasutaTab().getTxtChoShuryoYM().setDisabled(false);
        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().setDisabled(false);
        div.getHoshuMasutaTab().getTxtChoTanka().setDisabled(false);
    }

    private void set審査員報酬単価マスタ明細内容(dgChosainhoshuTankaIchiran_Row 選択行の審査委員報酬単価情報) {
        div.getHoshuMasutaTab().getTxtChoKaishiYM().setDomain(
                選択行の審査委員報酬単価情報.getKaishiYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getTxtChoShuryoYM().setDomain(
                選択行の審査委員報酬単価情報.getShuryoYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().
                setSelectedKey(選択行の審査委員報酬単価情報.getKaigoNinteiShinsaIinShubetsuCode());
        div.getHoshuMasutaTab().getTxtChoTanka().setValue(
                選択行の審査委員報酬単価情報.getTanka().getValue());
    }

    private boolean isデータ変更(dgChosainhoshuTankaIchiran_Row 選択データ) {
        return !(選択データ.getKaishiYM().getValue().getYearMonth().compareTo(
                div.getHoshuMasutaTab().getTxtChoKaishiYM().getDomain()) == 0
                && 選択データ.getShuryoYM().getValue().getYearMonth().compareTo(
                        div.getHoshuMasutaTab().getTxtChoShuryoYM().getDomain()) == 0
                && 選択データ.getKaigoNinteiShinsaIinShubetsuCode().equals(
                        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey())
                && (選択データ.getTanka().getValue() != null && 選択データ.getTanka().getValue().equals(
                        div.getHoshuMasutaTab().getTxtChoTanka().getValue())));
    }

    private static class DateComparatorChosainhoshu implements Comparator<dgChosainhoshuTankaIchiran_Row>, Serializable {

        private static final long serialVersionUID = -3338971128936347472L;

        @Override
        public int compare(dgChosainhoshuTankaIchiran_Row o1, dgChosainhoshuTankaIchiran_Row o2) {
            if (o2.getKaigoNinteiShinsaIinShubetsuCode().compareTo(o1.getKaigoNinteiShinsaIinShubetsuCode()) != 0) {
                return o2.getKaigoNinteiShinsaIinShubetsuCode().compareTo(o1.getKaigoNinteiShinsaIinShubetsuCode());
            } else {
                if (!o2.getKaishiYM().getValue().equals(o1.getKaishiYM().getValue())) {
                    return o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue());
                } else {
                    return o2.getShuryoYM().getValue().compareTo(o1.getShuryoYM().getValue());
                }
            }
        }
    }

    private void set意見書報酬単価マスタ明細状態_非活性() {
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().setDisabled(true);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().setDisabled(true);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().setDisabled(true);
    }

    private void set意見書報酬単価マスタ明細状態_活性() {
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().setDisabled(false);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().setDisabled(false);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().setDisabled(false);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().setDisabled(false);
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().setDisabled(false);
    }

    private void set意見書報酬単価マスタ明細内容(dgIkenShohoshuTankaIchiran_Row 選択行の意見書報酬単価情報) {
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().setDomain(
                選択行の意見書報酬単価情報.getKaishiYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().setDomain(
                選択行の意見書報酬単価情報.getShuryoYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().
                setSelectedKey(選択行の意見書報酬単価情報.getZaitakuShisetsuKubunCode());
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().
                setSelectedKey(選択行の意見書報酬単価情報.getIkenshoSakuseiKaisuKubunCode());
        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().setValue(
                選択行の意見書報酬単価情報.getTanka().getValue());
    }

    private boolean isデータ変更(dgIkenShohoshuTankaIchiran_Row 選択データ) {
        return !(選択データ.getKaishiYM().getValue().getYearMonth().compareTo(
                div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM().getDomain()) == 0
                && 選択データ.getShuryoYM().getValue().getYearMonth().compareTo(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM().getDomain()) == 0
                && 選択データ.getZaitakuShisetsuKubunCode().equals(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedKey())
                && 選択データ.getIkenshoSakuseiKaisuKubunCode().equals(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey())
                && (選択データ.getTanka().getValue() != null && 選択データ.getTanka().getValue().equals(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka().getValue())));
    }

    private static class DateComparatorIkenSho implements Comparator<dgIkenShohoshuTankaIchiran_Row>, Serializable {

        private static final long serialVersionUID = 2233415507675535717L;

        @Override
        public int compare(dgIkenShohoshuTankaIchiran_Row o1, dgIkenShohoshuTankaIchiran_Row o2) {
            if (o2.getZaitakuShisetsuKubunCode().compareTo(o1.getZaitakuShisetsuKubunCode()) != 0) {
                return o2.getZaitakuShisetsuKubunCode().compareTo(o1.getZaitakuShisetsuKubunCode());
            } else {
                if (o2.getIkenshoSakuseiKaisuKubunCode().compareTo(o1.getIkenshoSakuseiKaisuKubunCode()) != 0) {
                    return o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue());
                } else {
                    return o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue());
                }
            }
        }
    }

    private void set訪問調査報酬単価マスタ明細状態_非活性() {
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().setDisabled(true);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().setDisabled(true);
    }

    private void set訪問調査報酬単価マスタ明細状態_活性() {
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().setDisabled(false);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().setDisabled(false);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().setDisabled(false);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().setDisabled(false);
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().setDisabled(false);
    }

    private void set訪問調査報酬単価マスタ明細内容(dgHomonChosahoshuTankaIchiran_Row 選択行の訪問調査報酬単価情報) {
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().setDomain(
                選択行の訪問調査報酬単価情報.getKaishiYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().setDomain(
                選択行の訪問調査報酬単価情報.getShuryoYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().
                setSelectedKey(選択行の訪問調査報酬単価情報.getChosaKubunCode());
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().
                setSelectedKey(選択行の訪問調査報酬単価情報.getHomonShubetsuCode());
        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().setValue(
                選択行の訪問調査報酬単価情報.getTanka().getValue());
    }

    private boolean isデータ変更(dgHomonChosahoshuTankaIchiran_Row 選択データ) {
        return !(選択データ.getKaishiYM().getValue().getYearMonth().compareTo(
                div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM().getDomain()) == 0
                && 選択データ.getShuryoYM().getValue().getYearMonth().compareTo(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM().getDomain()) == 0
                && 選択データ.getChosaKubunCode().equals(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey())
                && 選択データ.getHomonShubetsuCode().equals(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey())
                && (選択データ.getTanka().getValue() != null && 選択データ.getTanka().getValue().equals(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka().getValue())));
    }

    private static class DateComparatorHomonChosa implements Comparator<dgHomonChosahoshuTankaIchiran_Row>, Serializable {

        private static final long serialVersionUID = 7114951338468415975L;

        @Override
        public int compare(dgHomonChosahoshuTankaIchiran_Row o1, dgHomonChosahoshuTankaIchiran_Row o2) {
            if (o2.getChosaKubunCode().compareTo(o1.getChosaKubunCode()) != 0) {
                return o2.getChosaKubunCode().compareTo(o1.getChosaKubunCode());
            } else {
                if (o2.getHomonShubetsuCode().compareTo(o1.getHomonShubetsuCode()) != 0) {
                    return o2.getHomonShubetsuCode().compareTo(o1.getHomonShubetsuCode());
                } else if (o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue()) != 0) {
                    return o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue());
                } else {
                    return o2.getShuryoYM().getValue().compareTo(o1.getShuryoYM().getValue());
                }
            }
        }
    }

    private void set審査会委員別単価マスタ明細状態_非活性() {
        div.getHoshuMasutaTab().getTxtBetuKaishiYM().setDisabled(true);
        div.getHoshuMasutaTab().getTxtBetuShuryoYM().setDisabled(true);
        div.getHoshuMasutaTab().getTxtShinsaIinKodo().setDisabled(true);
        div.getHoshuMasutaTab().getTxtBetuTanka().setDisabled(true);
        div.getHoshuMasutaTab().getTxtBetuSonotaTanka().setDisabled(true);
    }

    private void set審査会委員別単価マスタ明細状態_活性() {
        div.getHoshuMasutaTab().getTxtBetuKaishiYM().setDisabled(false);
        div.getHoshuMasutaTab().getTxtBetuShuryoYM().setDisabled(false);
        div.getHoshuMasutaTab().getTxtShinsaIinKodo().setDisabled(false);
        div.getHoshuMasutaTab().getTxtBetuTanka().setDisabled(false);
        div.getHoshuMasutaTab().getTxtBetuSonotaTanka().setDisabled(false);
    }

    private void set審査会委員別単価マスタ明細内容(dgShinsakaiIinBetuTanka_Row 選択行の審査会委員別単価情報) {
        div.getHoshuMasutaTab().getTxtBetuKaishiYM().setDomain(選択行の審査会委員別単価情報.getKaishiYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getTxtBetuShuryoYM().setDomain(選択行の審査会委員別単価情報.getShuryoYM().getValue().getYearMonth());
        div.getHoshuMasutaTab().getTxtShinsaIinKodo().setValue(選択行の審査会委員別単価情報.getShinsakaiIinCode());
        div.getHoshuMasutaTab().getTxtBetuTanka().setValue(選択行の審査会委員別単価情報.getTanka().getValue());
        div.getHoshuMasutaTab().getTxtBetuSonotaTanka().setValue(選択行の審査会委員別単価情報.getSonotaTanka().getValue());
    }

    private boolean isデータ変更(dgShinsakaiIinBetuTanka_Row 選択データ) {
        return !(選択データ.getKaishiYM().getValue().getYearMonth().compareTo(
                div.getHoshuMasutaTab().getTxtBetuKaishiYM().getDomain()) == 0
                && 選択データ.getShuryoYM().getValue().getYearMonth().compareTo(
                        div.getHoshuMasutaTab().getTxtBetuShuryoYM().getDomain()) == 0
                && 選択データ.getShinsakaiIinCode().equals(div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue())
                && (選択データ.getTanka().getValue() != null && 選択データ.getTanka().getValue().equals(
                        div.getHoshuMasutaTab().getTxtBetuTanka().getValue()))
                && (選択データ.getSonotaTanka().getValue() != null && 選択データ.getSonotaTanka().getValue().equals(
                        div.getHoshuMasutaTab().getTxtBetuSonotaTanka().getValue())));
    }

    private static class DateComparatorShinsakaiIinBetu implements Comparator<dgShinsakaiIinBetuTanka_Row>, Serializable {

        private static final long serialVersionUID = -7836273439314933445L;

        @Override
        public int compare(dgShinsakaiIinBetuTanka_Row o1, dgShinsakaiIinBetuTanka_Row o2) {
            if (o2.getShinsakaiIinCode().compareTo(o1.getShinsakaiIinCode()) != 0) {
                return o2.getShinsakaiIinCode().compareTo(o1.getShinsakaiIinCode());
            } else {
                if (o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue()) != 0) {
                    return o2.getKaishiYM().getValue().compareTo(o1.getKaishiYM().getValue());
                } else {
                    return o2.getShuryoYM().getValue().compareTo(o1.getShuryoYM().getValue());
                }
            }
        }
    }

}
