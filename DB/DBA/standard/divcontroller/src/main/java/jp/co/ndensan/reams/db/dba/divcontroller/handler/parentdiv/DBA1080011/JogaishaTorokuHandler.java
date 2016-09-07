/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanri;
import jp.co.ndensan.reams.db.dba.definition.core.jogaishatorokuparamter.JogaishaTorokuParamter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.JogaishaTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.dgNenreiTotatshusha_Row;
import jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriManager;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 資格取得除外者登録DivのHandlerクラスです。
 *
 * @reamsid_L DBA-0440-030 zhangzhiming
 */
public class JogaishaTorokuHandler {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 排他 = new RString("ShikakuShutokuJogaishaToroku");
    private final JogaishaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格取得除外者登録Divのエンティティ
     */
    public JogaishaTorokuHandler(JogaishaTorokuDiv div) {
        this.div = div;
    }

    /**
     * メニューから遷移します。
     *
     * @param 資格取得除外者情報 資格取得除外者情報
     */
    public void onLoad(List<ShikakuShutokuJogaishaKanri> 資格取得除外者情報) {
        List<dgNenreiTotatshusha_Row> rowList = new ArrayList<>();
        for (ShikakuShutokuJogaishaKanri 資格取得除外者 : 資格取得除外者情報) {
            dgNenreiTotatshusha_Row row = new dgNenreiTotatshusha_Row();
            row.setLasdecCode(資格取得除外者.getShichosonCode().getColumnValue());
            row.setLasdecMei(get市町村名(資格取得除外者.getShichosonCode()));
            row.setShikibetsuCode(資格取得除外者.getShikibetsuCode().getColumnValue());
            row.setRirekiNo(new RString(String.valueOf(資格取得除外者.getRirekiNo())));
            if (資格取得除外者.getMeisho() != null && !資格取得除外者.getMeisho().isEmpty()) {
                row.setShimei(資格取得除外者.getMeisho().getColumnValue());
            }
            row.getDateOfBirth().setValue(資格取得除外者.getSeinengappiYMD());
            row.setGender(資格取得除外者.getSeibetsuCode());
            row.setJuminJotai(資格取得除外者.getJuminJotaiCode());
            row.setJogaiRiyu(nullToEmpty(資格取得除外者.getShikakuShutokuJogaiRiyu()));
            if (資格取得除外者.getShikakuShutokuJogaiYMD() != null && !資格取得除外者.getShikakuShutokuJogaiYMD().isEmpty()) {
                row.getJogaiTekiyoDate().setValue(new RDate(資格取得除外者.getShikakuShutokuJogaiYMD().toString()));
            }
            if (資格取得除外者.getShikakuShutokuJogaiKaijoYMD() != null && !資格取得除外者.getShikakuShutokuJogaiKaijoYMD().isEmpty()) {
                row.getJogaiKaijyoDate().setValue(new RDate(資格取得除外者.getShikakuShutokuJogaiKaijoYMD().toString()));
            }
            rowList.add(row);
            アクセスログ(資格取得除外者.getShikibetsuCode());
        }
        div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().setDataSource(rowList);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(true);
        LockingKey lockingKey = new LockingKey(排他);
        if (!RealInitialLocker.tryGetLock(lockingKey)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
    }

    /**
     * 対象者検索画面から遷移します。
     *
     * @param jogaishaTorokuSetter 除外者データ
     */
    public void onLoadKen(JogaishaTorokuSetter jogaishaTorokuSetter) {
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().setValue(jogaishaTorokuSetter.getJogaiKaijyoYMD());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().setValue(jogaishaTorokuSetter.getJogaiRiyu());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().setValue(jogaishaTorokuSetter.getJogaiTekiyoYMD());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode()
                .setDomain(new ShikibetsuCode(jogaishaTorokuSetter.getShikibetsuCode()));
        div.getJogaishaTorokuIchiran().setStart(追加);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().setValue(jogaishaTorokuSetter.getShikibetsuCodeName());
        List<dgNenreiTotatshusha_Row> rowList = new ArrayList<>();
        ArrayList<JogaishaTorokuParamter> params = jogaishaTorokuSetter.getViewState();
        for (JogaishaTorokuParamter param : params) {
            dgNenreiTotatshusha_Row row = new dgNenreiTotatshusha_Row();
            row.setRowState(param.getRowState());
            row.setLasdecCode(param.getLasdecCode());
            row.setLasdecMei(param.getLasdecMei());
            row.setShikibetsuCode(param.getShikibetsuCode());
            row.setRirekiNo(param.getRirekiNo());
            row.setShimei(param.getShimei());
            row.getDateOfBirth().setValue(param.getDateOfBirth());
            row.setGender(param.getGender());
            row.setJuminJotai(param.getJuminJotai());
            row.setJogaiRiyu(param.getJogaiRiyu());
            row.getJogaiTekiyoDate().setValue(param.getJogaiTekiyoDate());
            row.getJogaiKaijyoDate().setValue(param.getJogaiKaijyoDate());
            rowList.add(row);
            アクセスログ(new ShikibetsuCode(param.getShikibetsuCode()));
        }
        div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().setDataSource(rowList);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnShikibetsuSearch().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnCacel().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnConfirm().setDisabled(false);
    }

    /**
     * 追加ボタンを押下します。
     */
    public void onClick_btnAdd() {
        div.getJogaishaTorokuIchiran().setStart(追加);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnShikibetsuSearch().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnCacel().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnConfirm().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().clearDomain();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().clearValue();
    }

    /**
     * 修正ボタンを押下します。
     */
    public void onClick_btnUpda() {
        div.getJogaishaTorokuIchiran().setStart(修正);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnShikibetsuSearch().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnCacel().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnConfirm().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().setDisabled(true);
        set除外対象者エリア(div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getActiveRow());
    }

    /**
     * 削除ボタンを押下します。
     */
    public void onClick_btnDele() {
        div.getJogaishaTorokuIchiran().setStart(削除);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnShikibetsuSearch().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnCacel().setDisabled(false);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getBtnConfirm().setDisabled(false);
        set除外対象者エリア(div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getActiveRow());
    }

    /**
     * 取消ボタンを押下します。
     */
    public void onClick_btnCacel() {
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(true);
        除外対象者エリアクリア();
    }

    /**
     * 識別コードLostFocusします。
     *
     */
    public void onFocus_shikibetsuCode() {
        ShikakuShutokuJogaishaKanri get宛名情報 = ShikakuShutokuJogaishaKanriManager.createInstance()
                .get宛名情報(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().getDomain());
        if (get宛名情報.getMeisho() != null && !get宛名情報.getMeisho().isEmpty()) {
            div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName()
                    .setValue(new RString(get宛名情報.getMeisho().toString()));
        }
        if (get宛名情報.getSeinengappiYMD() != null && !get宛名情報.getSeinengappiYMD().isEmpty()) {
            div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setTxtDateOfBirth(new RString(get宛名情報.getSeinengappiYMD().toString()));
        }
        if (get宛名情報.getShichosonCode() != null && !get宛名情報.getShichosonCode().isEmpty()) {
            div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setTxtLasdecCode(get宛名情報.getShichosonCode().getColumnValue());
            div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setTxtLasdecMei(get市町村名(new LasdecCode(get宛名情報
                    .getShichosonCode().getColumnValue())));
        }
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setTxtGender(get宛名情報.getSeibetsuCode());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setTxtJuminJotai(get宛名情報.getJuminJotaiCode());
    }

    /**
     * 識別対象検索ボタンを押下します。
     *
     * @return JogaishaTorokuSetter
     */
    public JogaishaTorokuSetter onClick_Search() {
        List<dgNenreiTotatshusha_Row> list = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
        ArrayList<JogaishaTorokuParamter> params = new ArrayList<>();
        for (dgNenreiTotatshusha_Row param : list) {
            JogaishaTorokuParamter paramter = new JogaishaTorokuParamter();
            paramter.setRowState(param.getRowState());
            paramter.setLasdecCode(param.getLasdecCode());
            paramter.setLasdecMei(param.getLasdecMei());
            paramter.setShikibetsuCode(param.getShikibetsuCode());
            paramter.setRirekiNo(param.getRirekiNo());
            paramter.setShimei(param.getShimei());
            paramter.setDateOfBirth(param.getDateOfBirth().getValue());
            paramter.setGender(param.getGender());
            paramter.setJuminJotai(param.getJuminJotai());
            paramter.setJogaiRiyu(param.getJogaiRiyu());
            paramter.setJogaiTekiyoDate(param.getJogaiTekiyoDate().getValue());
            paramter.setJogaiKaijyoDate(param.getJogaiKaijyoDate().getValue());
            params.add(paramter);
        }
        JogaishaTorokuSetter 除外者データ = new JogaishaTorokuSetter();
        除外者データ.setShikibetsuCode(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().getDomain().getColumnValue());
        除外者データ.setShikibetsuCodeName(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().getValue());
        除外者データ.setJogaiRiyu(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().getValue());
        除外者データ.setJogaiKaijyoYMD(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().getValue());
        除外者データ.setJogaiTekiyoYMD(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().getValue());
        除外者データ.setViewState(params);
        return 除外者データ;
    }

    /**
     * 確定ボタンを押下します。
     */
    public void onClick_btnKaku() {
        set一覧データグリッド();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().setDisabled(true);
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().clearDomain();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().clearValue();
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        return createValidationHandler(div).validateCheck();
    }

    /**
     * 保存するボタン押下の場合、重複チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs juufukuCheck() {
        return createValidationHandler(div).juufukuCheck();
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("識別コード"), 識別コード.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    private PersonalData withPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("識別コード"), 識別コード.value());
        return PersonalData.withHojinNo(識別コード, expandedInfo);
    }

    /**
     * アクセスログを出力します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void アクセスログ(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード));
        AccessLogger.log(AccessLogType.照会, withPersonalData(識別コード));
    }

    private void set除外対象者エリア(dgNenreiTotatshusha_Row row) {
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().setDomain(new ShikibetsuCode(row.getShikibetsuCode()));
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().setValue(row.getShimei());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().setValue(row.getJogaiRiyu());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().setValue(row.getJogaiTekiyoDate().getValue());
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().setValue(row.getJogaiKaijyoDate().getValue());
    }

    private void 除外対象者エリアクリア() {
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().clearDomain();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().clearValue();
        div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().clearValue();
        div.getJogaishaTorokuIchiran().setStart(RString.EMPTY);
    }

    private void set一覧データグリッド() {
        List<dgNenreiTotatshusha_Row> dgRowList = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getDataSource();
        int rowcount = 0;
        if (!div.getJogaishaTorokuIchiran().getStart().equals(追加)) {
            rowcount = div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().getClickedItem().getId();
        }
        dgNenreiTotatshusha_Row dgRow;
        if (div.getJogaishaTorokuIchiran().getStart().equals(修正)) {
            dgRow = dgRowList.get(rowcount);
            if (RowState.Added.equals(dgRow.getRowState())) {
                dgRow.setRowState(RowState.Added);
            } else {
                dgRow.setRowState(RowState.Modified);
            }
            dgRow.setShikibetsuCode(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().getDomain().getColumnValue());
            dgRow.setShimei(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().getValue());
            dgRow.setJogaiRiyu(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().getValue());
            dgRow.getJogaiKaijyoDate().setValue(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().getValue());
            dgRow.getJogaiTekiyoDate().setValue(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().getValue());
            dgRowList.set(rowcount, dgRow);
        }
        if (div.getJogaishaTorokuIchiran().getStart().equals(追加)) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            dgNenreiTotatshusha_Row addRow = new dgNenreiTotatshusha_Row();
            addRow.setRowState(RowState.Added);
            addRow.setShikibetsuCode(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCode().getDomain().getColumnValue());
            addRow.setShimei(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtShikibetsuCodeName().getValue());
            addRow.setJogaiRiyu(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiRiyu().getValue());
            addRow.getJogaiKaijyoDate().setValue(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiKaijyoYMD().getValue());
            addRow.getJogaiTekiyoDate().setValue(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJogaiTekiyoYMD().getValue());
            addRow.getDateOfBirth().setValue(new FlexibleDate(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtDateOfBirth()));
            addRow.setLasdecCode(association.get地方公共団体コード().value());
            addRow.setLasdecMei(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtLasdecMei());
            addRow.setGender(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtGender());
            addRow.setJuminJotai(div.getJogaishaTorokuIchiran().getJogaiTaishoIchiran().getTxtJuminJotai());
            dgRowList.add(addRow);
        }
        if (div.getJogaishaTorokuIchiran().getStart().equals(削除)) {
            dgRow = dgRowList.get(rowcount);
            if (dgRow.getRowState().equals(RowState.Added)) {
                dgRowList.remove(rowcount);
            } else {
                dgRow.setRowState(RowState.Deleted);
                dgRowList.set(rowcount, dgRow);
            }
        }
        div.getJogaishaTorokuIchiran().getNenreiTotatsh().getDgNenreiTotatshusha().setDataSource(dgRowList);
    }

    private RString get市町村名(LasdecCode 市町村コード) {
        SearchResult<ShichosonCodeYoriShichoson> 市町村情報
                = KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(市町村コード);
        if (市町村情報.records() != null && !市町村情報.records().isEmpty()) {
            return 市町村情報.records().get(0).get市町村名称();
        }
        return RString.EMPTY;
    }

    private JogaishaValidationHandler createValidationHandler(JogaishaTorokuDiv div) {
        return new JogaishaValidationHandler(div);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
