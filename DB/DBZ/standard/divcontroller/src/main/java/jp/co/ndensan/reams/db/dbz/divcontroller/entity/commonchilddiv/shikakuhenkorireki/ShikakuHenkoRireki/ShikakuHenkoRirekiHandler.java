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
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.sikakukanrenido.SikakuKanrenIdo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.param.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkorireki.ShikakuhenkorirekiFinder;
import jp.co.ndensan.reams.db.dbz.service.sikakukanrenidoa.SikakuKanrenIdoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ShikakuHenkoRireki のHandlerクラスファイル
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class ShikakuHenkoRirekiHandler {

    private static final Code 広域 = new Code("111");
    private static final RString 合併有り = new RString("1");
    private static final RString EMPTY_KEY = new RString("EMPTY");
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
     * @param 処理対象者 処理対象者
     * @param 取得日 取得日
     */
    public void initialize(HihokenshaNo 被保険者番号, IKojin 処理対象者, FlexibleDate 取得日) {
        Boolean is単一 = !ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().equals(広域);
        Boolean is合併有り = BusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告).equals(合併有り);
        if (is単一 && !is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiNashi);
        } else if (is単一 && is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
        } else if (!is単一 && !is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiNashi);
        } else if (!is単一 && is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiAri);
        }
        div.getDgHenko().setDataSource(get資格変更履歴(被保険者番号, 処理対象者.get識別コード(), 取得日));
        div.getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha().setDataSource(get措置元保険者DDL());
        div.getHenkoHokenshaJoho().getDdlHenkoKyuHokensha().setDataSource(get旧保険者リスト情報());
        div.getDdlHenkoJiyu().setDataSource(get変更事由リスト情報());
        div.getHenkoHokenshaJoho().getDdlJuminJoho().setDataSource(get住民情報DDL(処理対象者));
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
            div.setInputMode(ViewExecutionStatus.Add.getValue());
        } else if (ShikakuHenkoRirekiDiv.DisplayType.teiseitoroku.equals(div.getMode_DisplayType())) {
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleFalse);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
            div.getBtnHenkoKakutei().setVisible(true);
            div.getBtnHenkoTorikeshi().setVisible(true);
        }
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
            div.getDdlHenkoSochimotoHokensha().setSelectedValue(row.getSochimotoHokensha());
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
                = ViewStateHolder.get(ViewStateKeys.資格変更履歴_被保険者台帳情報, Models.class);
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
        ViewStateHolder.put(ViewStateKeys.資格変更履歴_被保険者台帳情報, result);
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
                return getHihokenshaDaicho(hihokenshaDaicho);
            }
        }
        return getHihokenshaDaicho(hihokenshaDaichoList.get(hihokenshaDaichoList.size() - 1));
    }

    private HihokenshaDaicho getHihokenshaDaicho(HihokenshaDaicho old) {
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(old.get被保険者番号(), FlexibleDate.getNowDate(), old.get枝番());
        HihokenshaDaichoBuilder hihokenshaDaichoBuilder = hihokenshaDaicho.createBuilderForEdit();
        hihokenshaDaichoBuilder.set異動事由コード(old.get異動事由コード());
        hihokenshaDaichoBuilder.set市町村コード(old.get市町村コード());
        hihokenshaDaichoBuilder.set識別コード(old.get識別コード());
        hihokenshaDaichoBuilder.set資格取得事由コード(old.get資格取得事由コード());
        hihokenshaDaichoBuilder.set資格取得年月日(old.get資格取得年月日());
        hihokenshaDaichoBuilder.set資格取得届出年月日(old.get資格取得届出年月日());
        hihokenshaDaichoBuilder.set第1号資格取得年月日(old.get第1号資格取得年月日());
        hihokenshaDaichoBuilder.set被保険者区分コード(old.get被保険者区分コード());
        hihokenshaDaichoBuilder.set資格喪失事由コード(old.get資格喪失事由コード());
        hihokenshaDaichoBuilder.set資格喪失年月日(old.get資格喪失年月日());
        hihokenshaDaichoBuilder.set資格喪失届出年月日(old.get資格喪失届出年月日());
        hihokenshaDaichoBuilder.set資格変更事由コード(old.get資格変更事由コード());
        hihokenshaDaichoBuilder.set資格変更年月日(old.get資格変更年月日());
        hihokenshaDaichoBuilder.set資格変更届出年月日(old.get資格変更届出年月日());
        hihokenshaDaichoBuilder.set住所地特例適用事由コード(old.get住所地特例適用事由コード());
        hihokenshaDaichoBuilder.set適用年月日(old.get適用年月日());
        hihokenshaDaichoBuilder.set適用届出年月日(old.get適用届出年月日());
        hihokenshaDaichoBuilder.set住所地特例解除事由コード(old.get住所地特例解除事由コード());
        hihokenshaDaichoBuilder.set解除年月日(old.get解除年月日());
        hihokenshaDaichoBuilder.set解除届出年月日(old.get解除届出年月日());
        hihokenshaDaichoBuilder.set住所地特例フラグ(old.get住所地特例フラグ());
        hihokenshaDaichoBuilder.set広域内住所地特例フラグ(old.get広域内住所地特例フラグ());
        hihokenshaDaichoBuilder.set広住特措置元市町村コード(old.get広住特措置元市町村コード());
        hihokenshaDaichoBuilder.set旧市町村コード(old.get旧市町村コード());
        hihokenshaDaichoBuilder.set論理削除フラグ(old.is論理削除フラグ());
        return hihokenshaDaichoBuilder.build();
    }

    private boolean isValueContains(List<KeyValueDataSource> list, RString value) {
        for (KeyValueDataSource item : list) {
            if (value.equals(item.getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isKeyContains(List<KeyValueDataSource> list, RString key) {
        for (KeyValueDataSource item : list) {
            if (key.equals(item.getKey())) {
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
            変更事由 = ShikakuHenkoJiyu.toValue(sikakuKanrenIdo.get住所地特例適用事由コード()).getName();
        } catch (IllegalArgumentException e) {
            変更事由 = RString.EMPTY;
        }
        TextBoxFlexibleDate 処理日時 = new TextBoxFlexibleDate();
        処理日時.setValue(new FlexibleDate(sikakuKanrenIdo.get処理日時().getDate().toDateString()));
        TextBoxFlexibleDate 異動日 = new TextBoxFlexibleDate();
        異動日.setValue(sikakuKanrenIdo.get異動日());
        RString 広住特措置元市町村コード = sikakuKanrenIdo.get広住特措置元市町村コード() == null ? RString.EMPTY : sikakuKanrenIdo.get広住特措置元市町村コード().getColumnValue();
        dgHenko_Row row = new dgHenko_Row(
                RString.EMPTY,
                変更日,
                届出日,
                変更事由,
                sikakuKanrenIdo.get住所地特例適用事由コード(),
                sikakuKanrenIdo.get市町村名称(),
                広住特措置元市町村コード,
                sikakuKanrenIdo.get旧市町村名称(),
                処理日時,
                sikakuKanrenIdo.get被保険者番号().getColumnValue(),
                識別コード.getColumnValue(),
                sikakuKanrenIdo.get市町村コード().getColumnValue(),
                異動日,
                sikakuKanrenIdo.get枝番().trim());
        return row;
    }

    private List<dgHenko_Row> get資格変更履歴(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        SikakuKanrenIdoFinder finder = SikakuKanrenIdoFinder.createInstance();
        List<SikakuKanrenIdo> kanrenIdos = finder.getSikakuKanrenIdo(SikakuKanrenIdoParameter.createParam(被保険者番号, 識別コード, 取得日)).records();
        HihokenshaDaichoManager manager = InstanceProvider.create(HihokenshaDaichoManager.class);
        List<HihokenshaDaicho> hihokenshaDaichoList = manager.get被保険者台帳管理一覧();
        List<HihokenshaDaicho> hihokenshaList = new ArrayList<>();
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result = Models.create(hihokenshaDaichoList);
        List<dgHenko_Row> rows = new ArrayList<>();
        for (SikakuKanrenIdo sikakuKanrenIdo : kanrenIdos) {
            rows.add(getDgHenko_RowFromSikakuKanrenIdo(sikakuKanrenIdo, 識別コード));
            hihokenshaList.add(result.get(new HihokenshaDaichoIdentifier(
                    sikakuKanrenIdo.get被保険者番号(),
                    sikakuKanrenIdo.get異動日(),
                    sikakuKanrenIdo.get枝番().trim())));
        }
        Collections.sort(hihokenshaList, new DateComparator());
        ViewStateHolder.put(ViewStateKeys.資格変更履歴_被保険者台帳情報, Models.create(hihokenshaList));
        return rows;
    }

    private static class DateComparator implements Comparator<HihokenshaDaicho>, Serializable {

        @Override
        public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
            return o2.get異動日().compareTo(o1.get異動日());
        }
    }

    private List<KeyValueDataSource> get措置元保険者DDL() {
        SikakuKanrenIdoFinder finder = SikakuKanrenIdoFinder.createInstance();
        List<KoseiShichosonMaster> shichosonMasters = finder.selectByKoseiShichosonMasterList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        int count = 1;
        for (KoseiShichosonMaster koseiShichosonMaster : shichosonMasters) {
            if (!RString.isNullOrEmpty(koseiShichosonMaster.getShoKisaiHokenshaNo().getColumnValue())) {
                dataSource.add(new KeyValueDataSource(
                        new RString(String.valueOf(count)), koseiShichosonMaster.getShoKisaiHokenshaNo().getColumnValue()));
                count++;
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get旧保険者リスト情報() {
        SikakuKanrenIdoFinder finder = SikakuKanrenIdoFinder.createInstance();
        List<GappeiShichoson> gappeiShichosons = finder.getGappeiShichosonList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        int count = 1;
        for (GappeiShichoson gappeiShichoson : gappeiShichosons) {
            if (!RString.isNullOrEmpty(gappeiShichoson.get旧保険者番号().getColumnValue())) {
                dataSource.add(new KeyValueDataSource(new RString(String.valueOf(count)), gappeiShichoson.get旧保険者番号().getColumnValue()));
                count++;
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get変更事由リスト情報() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        if (MENUID_DBAMN52003.equals(menuID)) {
            dataSource.add(new KeyValueDataSource(ShikakuHenkoRirekiEnum.広域内転居.getコード(),
                    ShikakuHenkoRirekiEnum.広域内転居.get名称()));
        } else if (MENUID_DBAMN52004.equals(menuID)) {
            dataSource.add(new KeyValueDataSource(ShikakuHenkoRirekiEnum.広住特適用.getコード(),
                    ShikakuHenkoRirekiEnum.広住特適用.get名称()));
            dataSource.add(new KeyValueDataSource(ShikakuHenkoRirekiEnum.広住特居住.getコード(),
                    ShikakuHenkoRirekiEnum.広住特居住.get名称()));
            dataSource.add(new KeyValueDataSource(ShikakuHenkoRirekiEnum.広住特転入.getコード(),
                    ShikakuHenkoRirekiEnum.広住特転入.get名称()));
            dataSource.add(new KeyValueDataSource(ShikakuHenkoRirekiEnum.広住特転居.getコード(),
                    ShikakuHenkoRirekiEnum.広住特転居.get名称()));
        } else if (MENUID_DBAMN52002.equals(menuID)) {
            dataSource.add(new KeyValueDataSource(ShikakuHenkoRirekiEnum.合併.getコード(),
                    ShikakuHenkoRirekiEnum.合併.get名称()));
        } else {
            for (ShikakuHenkoRirekiEnum shikakuHenkoRirekiEnum : ShikakuHenkoRirekiEnum.values()) {
                dataSource.add(new KeyValueDataSource(shikakuHenkoRirekiEnum.getコード(),
                        shikakuHenkoRirekiEnum.get名称()));
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get住民情報DDL(IKojin 処理対象者) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        ShikakuhenkorirekiFinder shikakuhenkorirekiManage = ShikakuhenkorirekiFinder.createInstance();
        List<IKojin> kojins = shikakuhenkorirekiManage.getKojinInfoByShikibetuCd(処理対象者);
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
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
        if (selectedKey.size() > 1) {
            市町村コード = selectedKey.get(1);
        }
        return 市町村コード;
    }

    private RString get識別コード() {
        List<RString> selectedKey = div.getDdlJuminJoho().getSelectedKey().split(半角コロン.toString());
        RString 識別コード = RString.EMPTY;
        if (selectedKey.size() > 1) {
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

    private enum ShikakuHenkoRirekiEnum {

        /**
         * コード:21 名称:転居 略称:定義なし
         */
        転居("21", "転居"),
        /**
         * コード:22 名称:氏名変更 略称:定義なし
         */
        氏名変更("22", "氏名変更"),
        /**
         * コード:11 名称:広域内転居 略称:定義なし
         */
        広域内転居("11", "広域内転居"),
        /**
         * コード:13 名称:広住特適用 略称:定義なし
         */
        広住特適用("13", "広住特適用"),
        /**
         * コード:14 名称:広住特転入 略称:定義なし
         */
        広住特転入("14", "広住特転入"),
        /**
         * コード:15 名称:広住特居住 略称:定義なし
         */
        広住特居住("15", "広住特居住"),
        /**
         * コード:17 名称:広住特転居 略称:定義なし
         */
        広住特転居("17", "広住特転居"),
        /**
         * コード:16 名称:合併内転居 略称:定義なし
         */
        合併内転居("16", "合併内転居"),
        /**
         * コード:41 名称:一本化 略称:定義なし
         */
        一本化("41", "一本化"),
        /**
         * コード:31 名称:１号到達 略称:定義なし
         */
        _１号到達("31", "１号到達"),
        /**
         * コード:42 名称:合併 略称:定義なし
         */
        合併("42", "合併"),
        /**
         * コード:23 名称:帰化 略称:定義なし
         */
        帰化("23", "帰化"),
        /**
         * コード:24 名称:国籍取得 略称:定義なし
         */
        国籍取得("24", "国籍取得"),
        /**
         * コード:48 名称:その他 略称:定義なし
         */
        その他("48", "その他");

        private final RString code;
        private final RString fullName;

        private ShikakuHenkoRirekiEnum(String code, String fullname) {
            this.code = new RString(code);
            this.fullName = new RString(fullname);
        }

        /**
         * 資格変更事由のコードを返します。
         *
         * @return 資格変更事由のコード
         */
        public RString getコード() {
            return code;
        }

        /**
         * 資格変更事由の名称を返します。
         *
         * @return 資格変更事由の名称
         */
        public RString get名称() {
            return fullName;
        }

        /**
         * 資格変更事由のコードと一致する内容を探します。
         *
         * @param code 資格変更事由のコード
         * @return {@code code} に対応する資格変更事由
         */
        public static ShikakuHenkoRirekiEnum toValue(RString code) {
            for (ShikakuHenkoRirekiEnum shikakuHenkoJiyu : ShikakuHenkoRirekiEnum.values()) {
                if (shikakuHenkoJiyu.code.equals(code)) {
                    return shikakuHenkoJiyu;
                }
            }
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格変更事由"));
        }
    }
}
