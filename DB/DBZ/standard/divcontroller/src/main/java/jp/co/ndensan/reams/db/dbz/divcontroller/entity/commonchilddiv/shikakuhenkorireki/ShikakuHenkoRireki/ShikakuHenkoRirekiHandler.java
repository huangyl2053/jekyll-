/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.sikakukanrenido.SikakuKanrenIdo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkorireki.ShikakuhenkorirekiFinder;
import jp.co.ndensan.reams.db.dbz.service.core.sikakukanrenidoa.SikakuKanrenIdoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ShikakuHenkoRireki のHandlerクラスファイル
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class ShikakuHenkoRirekiHandler {

    private static final Code 広域 = new Code("111");
    private static final RString 合併有り = new RString("1");
    private static final RString 半角コロン = new RString(":");
    private static final RString 追加状態 = new RString("追加");
    private static final RString 修正状態 = new RString("修正");
    private static final RString MENUID_DBAMN52003 = new RString("DBAMN52003");
    private static final RString MENUID_DBAMN52004 = new RString("DBAMN52004");
    private static final RString MENUID_DBAMN52002 = new RString("DBAMN52002");

    private final ShikakuHenkoRirekiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuHenkoRirekiDiv
     */
    public ShikakuHenkoRirekiHandler(ShikakuHenkoRirekiDiv div) {
        this.div = div;
    }

    /**
     * 引数から渡されたキーを元に被保険者台帳を検索し、その結果をグリッドに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     */
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        Boolean is単一 = !ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().equals(広域);
        Boolean is合併有り = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).equals(合併有り);
        if (is単一 && !is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiNashi);
        } else if (is単一 && is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
        } else if (!is単一 && !is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiNashi);
        } else if (!is単一 && is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiAri);
        }
        div.getDgHenko().setDataSource(get資格変更履歴(被保険者番号, 識別コード, 取得日));
        if (!is単一) {
            div.getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha().setDataSource(get措置元保険者DDL());
        }
        if (is合併有り) {
            div.getHenkoHokenshaJoho().getDdlHenkoKyuHokensha().setDataSource(get旧保険者リスト情報());
        }
        div.getDdlHenkoJiyu().setDataSource(get変更事由リスト情報());
        div.getHenkoHokenshaJoho().getDdlJuminJoho().setDataSource(get住民情報DDL(識別コード));
        if (ShikakuHenkoRirekiDiv.DisplayType.shokai.equals(div.getMode_DisplayType())) {
            div.setMode_BtnDisplayMode(ShikakuHenkoRirekiDiv.BtnDisplayMode.SetDisplayNone);
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleTrue);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
            div.getDgHenko().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgHenko().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgHenko().getGridSetting().setIsShowRowState(false);
        } else if (ShikakuHenkoRirekiDiv.DisplayType.toroku.equals(div.getMode_DisplayType())) {
            div.getBtnAdd().setDisabled(true);
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleFalse);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
            for (dgHenko_Row row : div.getDgHenko().getDataSource()) {
                row.setDeleteButtonState(DataGridButtonState.Disabled);
                row.setModifyButtonState(DataGridButtonState.Disabled);
            }
        } else if (ShikakuHenkoRirekiDiv.DisplayType.teiseitoroku.equals(div.getMode_DisplayType())) {
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleFalse);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
            div.getBtnHenkoKakutei().setVisible(true);
            div.getBtnHenkoTorikeshi().setVisible(true);
        }
        div.setInputMode(ViewExecutionStatus.Add.getValue());
    }

    /**
     * 資格変更履歴一覧の内容を明細エリアに反映します。
     */
    public void set資格変更入力Panel() {
        dgHenko_Row row = div.getDgHenko().getClickedItem();
        div.getTxtHenkoDate().setValue(row.getHenkoDate().getValue());
        div.getTxtHenkoTodokedeDate().setValue(row.getHenkoTodokedeDate().getValue());
        if (isValueContains(div.getDdlHenkoJiyu().getDataSource(), row.getHenkoJiyu())) {
            div.getDdlHenkoJiyu().setSelectedValue(row.getHenkoJiyu());
        } else {
            div.getDdlHenkoJiyu().setSelectedIndex(0);
        }
        if (isValueContains(div.getDdlHenkoSochimotoHokensha().getDataSource(), row.getSochimotoHokensha())) {
            div.getDdlHenkoSochimotoHokensha().setSelectedKey(row.getSochimotoHokensha());
        } else {
            div.getDdlHenkoSochimotoHokensha().setSelectedIndex(0);
        }
        if (isValueContains(div.getDdlHenkoKyuHokensha().getDataSource(), row.getKyuHokensha())) {
            div.getDdlHenkoKyuHokensha().setSelectedValue(row.getKyuHokensha());
        } else {
            div.getDdlHenkoKyuHokensha().setSelectedIndex(0);
        }
        RString 住民情報DDLKey = row.getShikibetsuCode().concat(半角コロン).concat(row.getShichosonCode());
        if (isKeyContains(div.getDdlJuminJoho().getDataSource(), 住民情報DDLKey)) {
            div.getDdlJuminJoho().setSelectedKey(住民情報DDLKey);
        } else {
            div.getDdlJuminJoho().setSelectedIndex(0);
        }
        div.setHihokenshaNo(row.getHihokenshaNo());
        div.setIdoDate(row.getIdoYMD().getValue().seireki().toDateString());
        div.setEdaban(row.getEdaNo());
    }

    /**
     * 明細エリアをクリアします。
     */
    public void clear資格変更入力Panel() {
        div.getTxtHenkoDate().clearValue();
        div.getTxtHenkoTodokedeDate().clearValue();
        div.getDdlHenkoJiyu().setSelectedIndex(0);
        div.getDdlHenkoSochimotoHokensha().setSelectedIndex(0);
        div.getDdlHenkoKyuHokensha().setSelectedIndex(0);
        div.getDdlJuminJoho().setSelectedIndex(0);
    }

    /**
     * 明細エリアを取得します。
     *
     * @return RString
     */
    public RString get資格変更入力Panel() {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(div.getTxtHenkoDate().getValue());
        rsb.append(div.getTxtHenkoTodokedeDate().getValue());
        rsb.append(div.getDdlHenkoJiyu().getSelectedKey());
        rsb.append(div.getDdlHenkoSochimotoHokensha().getSelectedKey());
        rsb.append(div.getDdlHenkoKyuHokensha().getSelectedKey());
        rsb.append(div.getDdlJuminJoho().getSelectedKey());
        return rsb.toRString();
    }

    /**
     * 明細エリアの入力内容を資格変更履歴一覧に反映します。
     *
     * @param 被保険者台帳情報 被保険者台帳情報
     */
    public void updateEntryData(HihokenshaDaicho 被保険者台帳情報) {
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result
                = ViewStateHolder.get(ViewStateKeys.被保険者台帳情報, Models.class);
        TextBoxFlexibleDate 変更日 = new TextBoxFlexibleDate();
        変更日.setValue(div.getTxtHenkoDate().getValue());
        TextBoxFlexibleDate 変更届出日 = new TextBoxFlexibleDate();
        変更届出日.setValue(div.getTxtHenkoTodokedeDate().getValue());
        TextBoxFlexibleDate 処理日時 = new TextBoxFlexibleDate();
        処理日時.setValue(FlexibleDate.EMPTY);
        if (div.getInputMode().equals(ViewExecutionStatus.Add.getValue())) {
            TextBoxFlexibleDate 異動日 = new TextBoxFlexibleDate();
            異動日.setValue(被保険者台帳情報.get異動日());
            dgHenko_Row row = new dgHenko_Row(
                    追加状態,
                    変更日,
                    変更届出日,
                    div.getDdlHenkoJiyu().getSelectedValue(),
                    div.getDdlHenkoJiyu().getSelectedKey(),
                    get所在保険者by市町村コード(get市町村コード()),
                    div.getDdlHenkoSochimotoHokensha().getSelectedValue(),
                    div.getDdlHenkoKyuHokensha().getSelectedValue(),
                    処理日時,
                    被保険者台帳情報.get被保険者番号().getColumnValue(),
                    被保険者台帳情報.get識別コード().getColumnValue(),
                    get市町村コード(),
                    異動日,
                    被保険者台帳情報.get枝番()
            );
            div.getDgHenko().getDataSource().add(row);
            result.add(setHihokenshaDaicho(被保険者台帳情報, row));
        } else if (div.getInputMode().equals(ViewExecutionStatus.Modify.getValue())) {
            RString 状態 = 修正状態;
            if (div.getDgHenko().getClickedItem().getState().equals(追加状態)) {
                状態 = 追加状態;
            }
            if (div.getDgHenko().getClickedItem().getState().equals(修正状態)) {
                被保険者台帳情報 = 被保険者台帳情報.modifiedModel();
            }
            TextBoxFlexibleDate 異動日 = new TextBoxFlexibleDate();
            異動日.setValue(被保険者台帳情報.get異動日());
            dgHenko_Row row = new dgHenko_Row(
                    状態,
                    変更日,
                    変更届出日,
                    div.getDdlHenkoJiyu().getSelectedValue(),
                    div.getDdlHenkoJiyu().getSelectedKey(),
                    get所在保険者by市町村コード(get市町村コード()),
                    div.getDdlHenkoSochimotoHokensha().getSelectedValue(),
                    div.getDdlHenkoKyuHokensha().getSelectedValue(),
                    処理日時,
                    被保険者台帳情報.get被保険者番号().getColumnValue(),
                    被保険者台帳情報.get識別コード().getColumnValue(),
                    get市町村コード(),
                    異動日,
                    被保険者台帳情報.get枝番()
            );

            result.add(setHihokenshaDaicho(被保険者台帳情報, row));
            div.getDgHenko().getDataSource().set(div.getDgHenko().getClickedRowId(), row);
        } else if (div.getInputMode().equals(ViewExecutionStatus.Delete.getValue())) {
            if (div.getDgHenko().getClickedItem().getState().equals(追加状態)) {
                div.getDgHenko().getDataSource().remove(div.getDgHenko().getClickedRowId());
            } else {
                div.getDgHenko().getClickedItem().setState(new RString("削除"));
                被保険者台帳情報 = 被保険者台帳情報.deleted();
                result.add(被保険者台帳情報);
            }
        }
        ViewStateHolder.put(ViewStateKeys.被保険者台帳情報, result);
    }

    private HihokenshaDaicho setHihokenshaDaicho(HihokenshaDaicho hihokenshaDaicho, dgHenko_Row row) {
        HihokenshaDaichoBuilder hihokenshaDaichoBuilder = hihokenshaDaicho.createBuilderForEdit();
        hihokenshaDaichoBuilder.set資格変更年月日(row.getHenkoDate().getValue());
        hihokenshaDaichoBuilder.set資格変更届出年月日(row.getHenkoTodokedeDate().getValue());
        hihokenshaDaichoBuilder.set資格変更事由コード(row.getHenkoJiyuKey());
        hihokenshaDaichoBuilder.set広住特措置元市町村コード(new LasdecCode(div.getDdlHenkoSochimotoHokensha().getSelectedKey()));
        if (div.getDdlJuminJoho().getIsBlankLine()) {
            hihokenshaDaichoBuilder.set旧市町村コード(new LasdecCode(div.getDdlHenkoKyuHokensha().getSelectedKey()));
        } else {
            hihokenshaDaichoBuilder.set旧市町村コード(new LasdecCode(get市町村コード()));
            hihokenshaDaichoBuilder.set識別コード(new ShikibetsuCode(get識別コード()));
        }
        return hihokenshaDaichoBuilder.build();
    }

    /**
     * 新規追加用Entityの元になるEntityを取得します。
     *
     * @param result 被保険者台帳情報
     * @return HihokenshaDaicho
     */
    public HihokenshaDaicho getTsuikaEntity(Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result) {
        List<HihokenshaDaicho> hihokenshaDaichoList = new ArrayList<>(result.values());
        Collections.sort(hihokenshaDaichoList, new DateComparator());
        for (HihokenshaDaicho hihokenshaDaicho : hihokenshaDaichoList) {
            if (!div.getTxtHenkoDate().getValue().isBefore(hihokenshaDaicho.get異動日())) {
                return getHihokenshaDaicho(hihokenshaDaicho, result);
            }
        }
        return getHihokenshaDaicho(hihokenshaDaichoList.get(hihokenshaDaichoList.size() - 1), result);
    }

    private HihokenshaDaicho getHihokenshaDaicho(HihokenshaDaicho old, Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result) {
        HihokenshaDaichoManager manager = InstanceProvider.create(HihokenshaDaichoManager.class);
        RString 枝番 = manager.get最大の枝番(old.get被保険者番号(), div.getTxtHenkoDate().getValue());
        int i = 1;
        for (dgHenko_Row row : div.getDgHenko().getDataSource()) {
            if (row.getHenkoDate().getValue().compareTo(div.getTxtHenkoDate().getValue()) == 0) {
                i = i + 1;
            }
        }
        if (RString.isNullOrEmpty(枝番)) {
            枝番 = new RString("0001");
        } else {
            枝番 = new RString(Integer.parseInt(枝番.toString()) + i).padZeroToLeft(4);
        }
        if (result.get(new HihokenshaDaichoIdentifier(old.get被保険者番号(),
                div.getTxtHenkoDate().getValue(), 枝番)) != null) {
            枝番 = new RString(Integer.parseInt(枝番.toString()) + i).padZeroToLeft(4);
        }
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(old.get被保険者番号(),
                div.getTxtHenkoDate().getValue(), 枝番);
        HihokenshaDaichoBuilder hihokenshaDaichoBuilder = hihokenshaDaicho.createBuilderForEdit();
        hihokenshaDaichoBuilder.set異動事由コード(old.get異動事由コード());
        hihokenshaDaichoBuilder.set市町村コード(old.get市町村コード());
        hihokenshaDaichoBuilder.set識別コード(old.get識別コード());
        hihokenshaDaichoBuilder.set資格取得事由コード(ObjectUtil.defaultIfNull(old.get資格取得事由コード(), RString.EMPTY));
        hihokenshaDaichoBuilder.set資格取得年月日(ObjectUtil.defaultIfNull(old.get資格取得年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set資格取得届出年月日(ObjectUtil.defaultIfNull(old.get資格取得届出年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set第1号資格取得年月日(ObjectUtil.defaultIfNull(old.get第1号資格取得年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set被保険者区分コード(old.get被保険者区分コード());
        hihokenshaDaichoBuilder.set資格喪失事由コード(ObjectUtil.defaultIfNull(old.get資格喪失事由コード(), RString.EMPTY));
        hihokenshaDaichoBuilder.set資格喪失年月日(ObjectUtil.defaultIfNull(old.get資格喪失年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set資格喪失届出年月日(ObjectUtil.defaultIfNull(old.get資格喪失届出年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set資格変更事由コード(ObjectUtil.defaultIfNull(old.get資格変更事由コード(), RString.EMPTY));
        hihokenshaDaichoBuilder.set資格変更年月日(ObjectUtil.defaultIfNull(old.get資格変更年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set資格変更届出年月日(ObjectUtil.defaultIfNull(old.get資格変更届出年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set住所地特例適用事由コード(
                ObjectUtil.defaultIfNull(old.get住所地特例適用事由コード(), RString.EMPTY));
        hihokenshaDaichoBuilder.set適用年月日(ObjectUtil.defaultIfNull(old.get適用年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set適用届出年月日(ObjectUtil.defaultIfNull(old.get適用届出年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set住所地特例解除事由コード(
                ObjectUtil.defaultIfNull(old.get住所地特例解除事由コード(), RString.EMPTY));
        hihokenshaDaichoBuilder.set解除年月日(ObjectUtil.defaultIfNull(old.get解除年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set解除届出年月日(ObjectUtil.defaultIfNull(old.get解除届出年月日(), FlexibleDate.EMPTY));
        hihokenshaDaichoBuilder.set住所地特例フラグ(ObjectUtil.defaultIfNull(old.get住所地特例フラグ(), RString.EMPTY));
        hihokenshaDaichoBuilder.set広域内住所地特例フラグ(
                ObjectUtil.defaultIfNull(old.get広域内住所地特例フラグ(), RString.EMPTY));
        hihokenshaDaichoBuilder.set広住特措置元市町村コード(
                ObjectUtil.defaultIfNull(old.get広住特措置元市町村コード(), LasdecCode.EMPTY));
        hihokenshaDaichoBuilder.set旧市町村コード(ObjectUtil.defaultIfNull(old.get旧市町村コード(), LasdecCode.EMPTY));
        hihokenshaDaichoBuilder.set論理削除フラグ(old.is論理削除フラグ());
        return hihokenshaDaichoBuilder.build();
    }

    private boolean isValueContains(List<KeyValueDataSource> list, RString value) {
        for (KeyValueDataSource item : list) {
            if (item.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    private boolean isKeyContains(List<KeyValueDataSource> list, RString key) {
        for (KeyValueDataSource item : list) {
            if (item.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private dgHenko_Row getDgHenko_RowFromSikakuKanrenIdo(SikakuKanrenIdo sikakuKanrenIdo, ShikibetsuCode 識別コード) {
        TextBoxFlexibleDate 変更日 = new TextBoxFlexibleDate();
        変更日.setValue(sikakuKanrenIdo.get資格変更年月日());
        TextBoxFlexibleDate 届出日 = new TextBoxFlexibleDate();
        届出日.setValue(sikakuKanrenIdo.get資格変更届出年月日());
        RString 変更事由;
        try {
            変更事由 = ShikakuHenkoJiyu.toValue(sikakuKanrenIdo.get住所地特例適用事由コード()).get名称();
        } catch (IllegalArgumentException e) {
            変更事由 = RString.EMPTY;
        }
        TextBoxFlexibleDate 処理日時 = new TextBoxFlexibleDate();
        処理日時.setValue(new FlexibleDate(sikakuKanrenIdo.get処理日時().getDate().toDateString()));
        TextBoxFlexibleDate 異動日 = new TextBoxFlexibleDate();
        異動日.setValue(sikakuKanrenIdo.get異動日());
        dgHenko_Row row = new dgHenko_Row(
                RString.EMPTY,
                変更日,
                届出日,
                変更事由,
                sikakuKanrenIdo.get住所地特例適用事由コード() == null
                ? RString.EMPTY : sikakuKanrenIdo.get住所地特例適用事由コード(),
                sikakuKanrenIdo.get市町村名称() == null ? RString.EMPTY : sikakuKanrenIdo.get市町村名称(),
                sikakuKanrenIdo.get措置元保険者() == null ? RString.EMPTY : sikakuKanrenIdo.get措置元保険者(),
                sikakuKanrenIdo.get旧市町村名称() == null ? RString.EMPTY : sikakuKanrenIdo.get旧市町村名称(),
                処理日時,
                sikakuKanrenIdo.get被保険者番号().getColumnValue(),
                識別コード.getColumnValue(),
                sikakuKanrenIdo.get市町村コード() == null ? RString.EMPTY : sikakuKanrenIdo.get市町村コード().getColumnValue(),
                異動日,
                sikakuKanrenIdo.get枝番().trim());
        return row;
    }

    private List<dgHenko_Row> get資格変更履歴(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        SikakuKanrenIdoFinder finder = SikakuKanrenIdoFinder.createInstance();
        List<SikakuKanrenIdo> kanrenIdos = finder.getSikakuKanrenIdo(SikakuKanrenIdoParameter.createParam(被保険者番号, 識別コード, 取得日)).records();
        HihokenshaDaichoManager manager = InstanceProvider.create(HihokenshaDaichoManager.class);
        List<HihokenshaDaicho> hihokenshaDaichoList = manager.get最新被保険者台帳(被保険者番号);
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result = Models.create(hihokenshaDaichoList);
        List<dgHenko_Row> rows = new ArrayList<>();
        Set<RString> keys = new HashSet<>();
        for (SikakuKanrenIdo shikakuKanrenIdo : kanrenIdos) {
            RString key = new RStringBuilder()
                    .append(shikakuKanrenIdo.get資格変更年月日().toString())
                    .append(shikakuKanrenIdo.get住所地特例適用事由コード()).toRString();
            if (keys.contains(key)) {
                continue;
            } else {
                keys.add(key);
            }
            rows.add(getDgHenko_RowFromSikakuKanrenIdo(shikakuKanrenIdo, 識別コード));
        }
        ViewStateHolder.put(ViewStateKeys.被保険者台帳情報, result);
        return rows;
    }

    private static class DateComparator implements Comparator<HihokenshaDaicho>, Serializable {

        private static final long serialVersionUID = -3192008985017883135L;

        @Override
        public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
            return o2.get異動日().compareTo(o1.get異動日());
        }

    }

    private List<KeyValueDataSource> get措置元保険者DDL() {
        SikakuKanrenIdoFinder finder = SikakuKanrenIdoFinder.createInstance();
        List<KoseiShichosonMaster> shichosonMasters = finder.selectByKoseiShichosonMasterList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (KoseiShichosonMaster koseiShichosonMaster : shichosonMasters) {
            if (!RString.isNullOrEmpty(koseiShichosonMaster.getShichosonCode().getColumnValue())) {
                dataSource.add(new KeyValueDataSource(
                        koseiShichosonMaster.getShichosonCode().getColumnValue(), koseiShichosonMaster.getShichosonMeisho()));
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get旧保険者リスト情報() {
        SikakuKanrenIdoFinder finder = SikakuKanrenIdoFinder.createInstance();
        List<GappeiShichoson> gappeiShichosons = finder.getGappeiShichosonList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (GappeiShichoson gappeiShichoson : gappeiShichosons) {
            if (!RString.isNullOrEmpty(gappeiShichoson.get旧市町村コード().getColumnValue())) {
                dataSource.add(new KeyValueDataSource(gappeiShichoson.get旧市町村コード().getColumnValue(), gappeiShichoson.get旧市町村名称()));
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get変更事由リスト情報() {
        RString menuID = ResponseHolder.getMenuID();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        if (MENUID_DBAMN52003.equals(menuID)) {
            dataSource.add(new KeyValueDataSource(ShikakuHenkoJiyu.広域内転居.getコード(),
                    ShikakuHenkoJiyu.広域内転居.get名称()));
        } else if (MENUID_DBAMN52004.equals(menuID)) {
            dataSource.add(new KeyValueDataSource(ShikakuHenkoJiyu.広住特適用.getコード(),
                    ShikakuHenkoJiyu.広住特適用.get名称()));
            dataSource.add(new KeyValueDataSource(ShikakuHenkoJiyu.広住特居住.getコード(),
                    ShikakuHenkoJiyu.広住特居住.get名称()));
            dataSource.add(new KeyValueDataSource(ShikakuHenkoJiyu.広住特転入.getコード(),
                    ShikakuHenkoJiyu.広住特転入.get名称()));
            dataSource.add(new KeyValueDataSource(ShikakuHenkoJiyu.広住特転居.getコード(),
                    ShikakuHenkoJiyu.広住特転居.get名称()));
        } else if (MENUID_DBAMN52002.equals(menuID)) {
            dataSource.add(new KeyValueDataSource(ShikakuHenkoJiyu.合併.getコード(),
                    ShikakuHenkoJiyu.合併.get名称()));
        } else {
            for (ShikakuHenkoJiyu shikakuHenkoRirekiEnum : ShikakuHenkoJiyu.values()) {
                dataSource.add(new KeyValueDataSource(shikakuHenkoRirekiEnum.getコード(),
                        shikakuHenkoRirekiEnum.get名称()));
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get住民情報DDL(ShikibetsuCode 識別コード) {

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        ShikakuhenkorirekiFinder shikakuhenkorirekiManage = ShikakuhenkorirekiFinder.createInstance();
        List<IKojin> kojins = shikakuhenkorirekiManage.getKojinInfoByShikibetuCd(識別コード);
        for (IKojin iKojin : kojins) {
            dataSource.add(
                    new KeyValueDataSource(iKojin.get識別コード().getColumnValue().
                            concat(半角コロン).
                            concat(iKojin.get現全国地方公共団体コード().getColumnValue()),
                            get住民情報(iKojin)));
        }
        return dataSource;
    }

    private RString get住民情報(IKojin kojin) {
        ShikibetsuCode 識別コード = kojin.get識別コード();
        LasdecCode 市町村コード = kojin.get現全国地方公共団体コード();
        JuminJotai 住民状態 = kojin.get住民状態();
        RString 生年月日;
        AtenaKanaMeisho カナ氏名;
        if (kojin.is日本人()) {
            生年月日 = kojin.get生年月日().toFlexibleDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
            カナ氏名 = kojin.get日本人氏名().getKana();
        } else {
            生年月日 = kojin.get生年月日().toFlexibleDate().seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            カナ氏名 = kojin.get外国人氏名().get外国人氏名カナ();
        }
        return get住民情報Format(識別コード.getColumnValue(), 市町村コード.getColumnValue(), 住民状態.住民状態略称(), 生年月日, カナ氏名.getColumnValue());
    }

    private RString get住民情報Format(RString 識別コード, RString 市町村コード, RString 住民状態略称, RString 生年月日, RString カナ氏名) {
        return 識別コード.concat(半角コロン).concat(市町村コード).concat(半角コロン).concat(住民状態略称).concat(半角コロン).concat(生年月日)
                .concat(半角コロン).concat(カナ氏名);
    }

    private RString get市町村コード() {
        List<RString> selectedKey = div.getDdlJuminJoho().getSelectedKey().split(半角コロン.toString());
        RString 市町村コード = RString.EMPTY;
        if (1 < selectedKey.size()) {
            市町村コード = selectedKey.get(1);
        }
        return 市町村コード;
    }

    private RString get識別コード() {
        List<RString> selectedKey = div.getDdlJuminJoho().getSelectedKey().split(半角コロン.toString());
        RString 識別コード = RString.EMPTY;
        if (1 < selectedKey.size()) {
            識別コード = selectedKey.get(0);
        }
        return 識別コード;
    }

    private RString get所在保険者by市町村コード(RString 市町村コード) {
        List<dgHenko_Row> rows = div.getDgHenko().getDataSource();
        for (dgHenko_Row henko_Row : rows) {
            if (市町村コード.equals(henko_Row.getShichosonCode())) {
                return henko_Row.getShozaiHokensha();
            }
        }
        return RString.EMPTY;
    }
}
