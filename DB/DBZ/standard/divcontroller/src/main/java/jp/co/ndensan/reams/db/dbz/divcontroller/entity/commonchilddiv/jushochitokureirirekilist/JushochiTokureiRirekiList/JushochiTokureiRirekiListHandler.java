/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.business.jushotitokure.JushotiTokureiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiRirekiListDiv.DisplayType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.jushotitokurei.JushotiTokureiFinder;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.session.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 共有子Div「住所地特例履歴」の状態を変更するクラスです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiRirekiListHandler {

    private final JushochiTokureiRirekiListDiv jutokuRirekiDiv;
    private static final RString PANEL_SESSION_ACCESSOR_EDITING_KEY = new RString("jushochiTokureiRireki_Editing");

    /**
     * コンストラクタです。
     *
     * @param jutokuRirekiDiv 住所地特例履歴ListDiv
     */
    public JushochiTokureiRirekiListHandler(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        this.jutokuRirekiDiv = jutokuRirekiDiv;
    }

    /**
     * 共有子Divが持つ住所地特例処理モードを元に、適切な明細入力モードを設定します。
     */
    public void setMeisaiInputMode() {
        DisplayType displayType = jutokuRirekiDiv.getMode_DisplayType();

        switch (displayType) {
            case tekiyo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoInput);
                break;
            case kaijo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoInput);
                break;
            case teiseitoroku:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiInput);
                break;
            default:
                break;

        }
    }

    /**
     * 共有子Divが持つ住所地特例処理モードを元に、適切な明細照会モードを設定します。
     */
    public void setMeisaiShokaiMode() {
        DisplayType displayType = jutokuRirekiDiv.getMode_DisplayType();
        switch (displayType) {
            case tekiyo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoShokai);
                break;
            case kaijo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoShokai);
                break;
            case teiseitoroku:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiShokai);
                break;
            default:
                break;
        }
    }

    /**
     * 共有子Divが持つ住所地特例処理モードを元に適切な明細照会モードを設定し、かつ確定・取消ボタンを押下可能にします。
     */
    public void setMeisaiDeleteMode() {
        setMeisaiShokaiMode();
        jutokuRirekiDiv.getBtnAdd().setDisabled(false);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(false);
    }

    /**
     * グリッド上で選択した住所地特例異動の情報を、明細エリアに表示します。
     */
    public void showSelectedData() {
        dgJutoku_Row row = jutokuRirekiDiv.getDgJutoku().getClickedItem();

        jutokuRirekiDiv.getJutokuTekiyoInput().getTxtTekiyoDate().setValue(row.getTekiyoDate().getValue());
        jutokuRirekiDiv.getJutokuTekiyoInput().getTxtTekiyoTodokedeDate().setValue(row.getTekiyoTodokedeDate().getValue());
        jutokuRirekiDiv.getJutokuTekiyoInput().getDdlTekiyoJiyu().setDataSource(getCode(new CodeShubetsu("0008")));
        try {
            jutokuRirekiDiv.getJutokuTekiyoInput().getDdlTekiyoJiyu().setSelectedKey(row.getTekiyoJiyuKey());
        } catch (SystemException e) {
            jutokuRirekiDiv.getJutokuTekiyoInput().getDdlTekiyoJiyu().setSelectedKey(RString.EMPTY);

        }
        jutokuRirekiDiv.getJutokuKaijoInput().getTxtKaijoDate().setValue(row.getKaijoDate().getValue());
        jutokuRirekiDiv.getJutokuKaijoInput().getTxtKaijoTodokedeDate().setValue(row.getKaijoTodokedeDate().getValue());
        jutokuRirekiDiv.getJutokuKaijoInput().getDdlKaijoJiyu().setDataSource(getCode(new CodeShubetsu("0011")));
        try {
            jutokuRirekiDiv.getJutokuKaijoInput().getDdlKaijoJiyu().setSelectedKey(row.getKaijoJiyuKey());
        } catch (SystemException e) {
            jutokuRirekiDiv.getJutokuKaijoInput().getDdlKaijoJiyu().setSelectedKey(RString.EMPTY);
        }

    }

    /**
     * 明細エリアの情報を初期化します。
     */
    public void clearInputData() {

        jutokuRirekiDiv.getJutokuTekiyoInput().setTekiyojiShichosonCode(RString.EMPTY);
        jutokuRirekiDiv.getJutokuTekiyoInput().setTekiyojiHihokenshaNo(RString.EMPTY);
        jutokuRirekiDiv.getJutokuTekiyoInput().setTekiyojiShoriDatetime(RString.EMPTY);

        jutokuRirekiDiv.getTxtTekiyoDate().setValue(FlexibleDate.EMPTY);
        jutokuRirekiDiv.getTxtTekiyoTodokedeDate().setValue(FlexibleDate.EMPTY);
        jutokuRirekiDiv.getDdlTekiyoJiyu().setSelectedIndex(0);
//        jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().setSelectedIndex(0);
//        jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedIndex(0);
//        jutokuRirekiDiv.getDdlTekiyojiJuminJoho().setDataSource(Lists.newArrayList(new KeyValueDataSource()));

        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiShichosonCode(RString.EMPTY);
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiHihokenshaNo(RString.EMPTY);
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiShoriDatetime(RString.EMPTY);

        jutokuRirekiDiv.getTxtKaijoDate().setValue(FlexibleDate.EMPTY);
        jutokuRirekiDiv.getTxtKaijoTodokedeDate().setValue(FlexibleDate.EMPTY);
        jutokuRirekiDiv.getDdlKaijoJiyu().setSelectedIndex(0);
//        jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().setSelectedIndex(0);
//        jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setSelectedIndex(0);
//        jutokuRirekiDiv.getDdlKaijojiJuminJono().setDataSource(Lists.newArrayList(new KeyValueDataSource()));

    }

    /**
     * Divに登録されている、変更される被保険者台帳Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> getEditing被保険者台帳情報() {
        IItemList<HihokenshaDaichoModel> editing被保険者台帳List
                = ItemList.of(PanelSessionAccessor.get(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_EDITING_KEY, ArrayList.class));
        return editing被保険者台帳List;
    }

    /**
     * 明細パネルに入力されている情報を元に、自身の持つ被保険者台帳履歴を更新します。
     */
    public void updateEntryData() {
        RString status = jutokuRirekiDiv.getExecutionStatus();
        if (ViewExecutionStatus.Add.getValue().equals(status)) {
            dgJutoku_Row newRow = add住所地特例履歴();
            int rowNo = jutokuRirekiDiv.getDgJutoku().getTotalRecords();
            jutokuRirekiDiv.getDgJutoku().getDataSource().add(newRow);
        } else if (ViewExecutionStatus.Modify.getValue().equals(status)) {
            dgJutoku_Row row = jutokuRirekiDiv.getDgJutoku().getClickedItem();
            TextBoxDate shoriDate = new TextBoxDate();
            shoriDate.setValue(RDate.getNowDate());
            TextBoxFlexibleDate tekiyoDate = new TextBoxFlexibleDate();
            tekiyoDate.setValue(jutokuRirekiDiv.getTxtTekiyoDate().getValue());
            TextBoxFlexibleDate tekiyoTodokedeDate = new TextBoxFlexibleDate();
            tekiyoTodokedeDate.setValue(jutokuRirekiDiv.getTxtTekiyoTodokedeDate().getValue());
            TextBoxFlexibleDate kaijoDate = new TextBoxFlexibleDate();
            kaijoDate.setValue(jutokuRirekiDiv.getTxtKaijoDate().getValue());
            TextBoxFlexibleDate kaijoTodokedeDate = new TextBoxFlexibleDate();
            kaijoTodokedeDate.setValue(jutokuRirekiDiv.getTxtKaijoTodokedeDate().getValue());
            row.setState(new RString("修正"));
            row.setTekiyoDate(tekiyoDate);
            row.setTekiyoTodokedeDate(tekiyoTodokedeDate);
            row.setKaijoDate(kaijoDate);
            row.setKaijoTodokedeDate(kaijoTodokedeDate);
            row.setShoriDate(shoriDate);
            jutokuRirekiDiv.getDgJutoku().getDataSource().set(jutokuRirekiDiv.getDgJutoku().getClickedRowId(), row);
        } else if (ViewExecutionStatus.Delete.getValue().equals(status)) {
            dgJutoku_Row row = jutokuRirekiDiv.getDgJutoku().getClickedItem();
            TextBoxDate shoriDate = new TextBoxDate();
            shoriDate.setValue(RDate.getNowDate());
            row.setState(new RString("削除"));
            row.setShoriDate(shoriDate);
            jutokuRirekiDiv.getDgJutoku().getDataSource().set(jutokuRirekiDiv.getDgJutoku().getClickedRowId(), row);
        }
    }

    private dgJutoku_Row add住所地特例履歴() {
        TextBoxDate shoriDate = new TextBoxDate();
        shoriDate.setValue(RDate.getNowDate());
        TextBoxFlexibleDate tekiyoDate = new TextBoxFlexibleDate();
        tekiyoDate.setValue(jutokuRirekiDiv.getTxtTekiyoDate().getValue());
        TextBoxFlexibleDate tekiyoTodokedeDate = new TextBoxFlexibleDate();
        tekiyoTodokedeDate.setValue(jutokuRirekiDiv.getTxtTekiyoTodokedeDate().getValue());
        TextBoxFlexibleDate kaijoDate = new TextBoxFlexibleDate();
        kaijoDate.setValue(jutokuRirekiDiv.getTxtKaijoDate().getValue());
        TextBoxFlexibleDate kaijoTodokedeDate = new TextBoxFlexibleDate();
        kaijoTodokedeDate.setValue(jutokuRirekiDiv.getTxtKaijoTodokedeDate().getValue());
        return new dgJutoku_Row(
                new RString("追加"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                tekiyoDate,
                tekiyoTodokedeDate,
                jutokuRirekiDiv.getDdlTekiyoJiyu().getSelectedValue(),
                jutokuRirekiDiv.getDdlTekiyoJiyu().getSelectedKey(),
                kaijoDate,
                kaijoTodokedeDate,
                jutokuRirekiDiv.getDdlKaijoJiyu().getSelectedValue(),
                jutokuRirekiDiv.getDdlKaijoJiyu().getSelectedKey(),
                RString.EMPTY,
                RString.EMPTY,
                shoriDate);
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     */
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {

        JushotiTokureiFinder jushotiTokureiFinder = new JushotiTokureiFinder();
        SearchResult<JushotiTokureiBusiness> rusult = jushotiTokureiFinder.getJushotiTokureiJoho(被保険者番号, 識別コード, 取得日);
        List<dgJutoku_Row> dgJutokuList = new ArrayList();
        if (!rusult.records().isEmpty()) {
            for (JushotiTokureiBusiness jushotiTokureiBusiness : rusult.records()) {

                dgJutoku_Row row = new dgJutoku_Row();

                TextBoxFlexibleDate 適用日 = new TextBoxFlexibleDate();
                適用日.setValue(jushotiTokureiBusiness.get適用日());
                row.setTekiyoDate(適用日);

                TextBoxFlexibleDate 適用届出日 = new TextBoxFlexibleDate();
                適用届出日.setValue(jushotiTokureiBusiness.get適用届出日());
                row.setTekiyoTodokedeDate(適用届出日);

                try {
                    row.setTekiyoJiyu(ShikakuJutokuTekiyoJiyu.toValue(jushotiTokureiBusiness.get適用事由コード()).get名称());
                } catch (IllegalArgumentException e) {
                    row.setTekiyoJiyu(RString.EMPTY);
                }
                row.setTekiyoJiyuKey(jushotiTokureiBusiness.get適用事由コード());
                TextBoxFlexibleDate 解除日 = new TextBoxFlexibleDate();
                解除日.setValue(jushotiTokureiBusiness.get解除日());
                row.setKaijoDate(解除日);

                TextBoxFlexibleDate 解除届出日 = new TextBoxFlexibleDate();
                解除届出日.setValue(jushotiTokureiBusiness.get解除届出日());
                row.setKaijoTodokedeDate(解除届出日);

                try {
                    row.setKaijoJiyu(ShikakuJutokuKaijoJiyu.toValue(jushotiTokureiBusiness.get解除事由コード()).get名称());
                } catch (IllegalArgumentException e) {
                    row.setKaijoJiyu(RString.EMPTY);
                }
                row.setKaijoJiyuKey(jushotiTokureiBusiness.get解除事由コード());
                //措置元保険者 旧保険者 処理日時

                dgJutokuList.add(row);
            }
            jutokuRirekiDiv.getDgJutoku().setDataSource(dgJutokuList);
        }

        jutokuRirekiDiv.getJutokuTekiyoInput().getDdlTekiyoJiyu().setDataSource(getCode(new CodeShubetsu("0008")));
        jutokuRirekiDiv.getJutokuKaijoInput().getDdlKaijoJiyu().setDataSource(getCode(new CodeShubetsu("0011")));

        // 画面に初期化表示制御
        initBtnDisplay();

    }

    private void setTekiyoJiyuDataSource() {
        //TODO n8235　船山洋介 DBXCodeShubetsuがICodeShubetsuに適応できないため、コメントアウト。　使用できるようになったら修正。
        // List<KaigoShikakuHenkoJiyu> tekiyoList = CodeMasterHelper.getCode(DBXCodeShubetsu.介護資格住特適用事由);
//        IItemList<KeyValueDataSource> dataSource = ItemList.of(tekiyoList).map(new CodeMasterToKeyValueFunction());
//        jutokuRirekiDiv.getDdlTekiyoJiyu().setDataSource(dataSource.toList());
    }

    private void setKaijoJiyuDataSource() {
        //TODO n8235　船山洋介 DBXCodeShubetsuがICodeShubetsuに適応できないため、コメントアウト。　使用できるようになったら修正。
        // List<KaigoShikakuJutokuKaijoJiyu> kaijoList = CodeMasterHelper.getCode(DBXCodeShubetsu.介護資格住特解除事由);
//        IItemList<KeyValueDataSource> dataSource = ItemList.of(kaijoList).map(new CodeMasterToKeyValueFunction());
//        jutokuRirekiDiv.getDdlKaijoJiyu().setDataSource(dataSource.toList());
    }

    private List<KeyValueDataSource> creaateRStringKeyValue(List<RString> dataSource) {
        List<KeyValueDataSource> keyValueDataSourceList = new ArrayList<>();
        for (int i = 0; i < dataSource.size(); i++) {
            RString indexStr = new RString(Integer.toString(i));
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(indexStr, dataSource.get(i));
            keyValueDataSourceList.add(keyValueDataSource);
        }
        return keyValueDataSourceList;
    }

    //TODO n8178 城間篤人 市町村情報を受け取り、市町村コードと市町村名でDDLを作成する。 2014年12月24日
    private List<KeyValueDataSource> creaateShichosonKeyValue(List dataSource) {
        List<KeyValueDataSource> keyValueDataSourceList = new ArrayList<>();
        for (Object data : dataSource) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(null, null);
            keyValueDataSourceList.add(keyValueDataSource);
        }
        return keyValueDataSourceList;
    }

    /**
     * 明細に入力可能になる前に共通的に使用される処理です。<br/>
     * <ul>
     * <li>追加ボタンに非活性を設定</li>
     * <li>住所地特例グリッドに読み込み不可を設定</li>
     * <li>適用情報入力パネルと解除情報入力パネルが活性に変更</li>
     * </ul>
     */
    public void setupToBeforeInput() {
        jutokuRirekiDiv.getBtnAdd().setDisabled(true);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(true);
        jutokuRirekiDiv.getJutokuTekiyoInput().setDisplayNone(false);
        jutokuRirekiDiv.getJutokuTekiyoInput().setDisabled(false);
        jutokuRirekiDiv.getJutokuKaijoInput().setDisplayNone(false);
        jutokuRirekiDiv.getJutokuKaijoInput().setDisabled(false);
    }

    /**
     * 明細に入力が完了したときや、取消ボタンの押下等によって入力を取りやめた場合に、共通的に使用される処理です。<br/>
     * <ul>
     * <li>追加ボタンに活性を設定</li>
     * <li>住所地特例グリッドに読み込み可を設定</li>
     * </ul>
     */
    public void setupToAfterInput() {
        jutokuRirekiDiv.getBtnAdd().setDisabled(false);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(false);
    }

    /**
     * 自身が持つ処理区分に対して、引数から受け取った値を設定します。
     *
     * @param status 処理区分
     */
    public void setExecutionStatus(ViewExecutionStatus status) {
        jutokuRirekiDiv.setExecutionStatus(status.getValue());
    }

    /**
     * 住所地特例履歴Listが内部で持つ、被保険者台帳情報に変更が存在するか否かを判定します。
     *
     * @return 被保険者台帳情報に変更が存在するならtrue
     */
    public boolean hasChanged() {
        IItemList<HihokenshaDaichoModel> daichoList = getEditing被保険者台帳情報();
//        for (HihokenshaDaichoModel daicho : daichoList) {
//            if (daicho.getState() == EntityDataState.Unchanged) {
//                continue;
//            }
//            return true;
//        }
        return false;
    }

    private DbT1001HihokenshaDaichoEntity deepCopy(DbT1001HihokenshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity copy = new DbT1001HihokenshaDaichoEntity();

        copy.setShichosonCode(new LasdecCode(entity.getShichosonCode().getColumnValue().toString()));
        copy.setHihokenshaNo(new HihokenshaNo(new RString(entity.getHihokenshaNo().getColumnValue().toString())));
//        RDateTime copyDateTime = entity.getShoriTimestamp().getColumnValue().getRDateTime();
//        copy.setShoriTimestamp(ShoriTimestamp.of(
//                RDateTime.of(copyDateTime.getYear(), copyDateTime.getMonth(), copyDateTime.getDayOfMonth(),
//                        copyDateTime.getHour(), copyDateTime.getMinute(), copyDateTime.getSecond())
//        ));
        copy.setShikibetsuCode(new ShikibetsuCode(entity.getShikibetsuCode().getColumnValue().toString()));

        copy.setShikakuShutokuJiyuCode(entity.getShikakuShutokuJiyuCode());
        copy.setShikakuShutokuYMD(new FlexibleDate(entity.getShikakuShutokuYMD().toString()));
        copy.setShikakuShutokuTodokedeYMD(new FlexibleDate(entity.getShikakuShutokuTodokedeYMD().toString()));

        copy.setIchigoShikakuShutokuYMD(new FlexibleDate(entity.getIchigoShikakuShutokuYMD().toString()));
        copy.setHihokennshaKubunCode(new RString(entity.getHihokennshaKubunCode().toString()));

        copy.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        copy.setShikakuSoshitsuYMD(new FlexibleDate(entity.getShikakuSoshitsuYMD().toString()));
        copy.setShikakuSoshitsuTodokedeYMD(new FlexibleDate(entity.getShikakuSoshitsuTodokedeYMD().toString()));

        copy.setJushochiTokureiFlag(new RString(entity.getJushochiTokureiFlag().toString()));

        copy.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        copy.setShikakuHenkoYMD(new FlexibleDate(entity.getShikakuHenkoYMD().toString()));
        copy.setShikakuHenkoTodokedeYMD(new FlexibleDate(entity.getShikakuHenkoTodokedeYMD().toString()));

        copy.setJushochitokureiTekiyoJiyuCode(entity.getJushochitokureiTekiyoJiyuCode());
        copy.setJushochitokureiTekiyoYMD(new FlexibleDate(entity.getJushochitokureiTekiyoYMD().toString()));
        copy.setJushochitokureiTekiyoTodokedeYMD(new FlexibleDate(entity.getJushochitokureiTekiyoTodokedeYMD().toString()));

        copy.setJushochitokureiKaijoJiyuCode(entity.getJushochitokureiKaijoJiyuCode());
        copy.setJushochitokureiKaijoYMD(new FlexibleDate(entity.getJushochitokureiKaijoYMD().toString()));
        copy.setJushochitokureiKaijoTodokedeYMD(new FlexibleDate(entity.getJushochitokureiKaijoTodokedeYMD().toString()));

        copy.setKoikinaiJushochiTokureiFlag(new RString(entity.getKoikinaiJushochiTokureiFlag().toString()));

        copy.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(entity.getKoikinaiTokureiSochimotoShichosonCode().getColumnValue().toString()));
        copy.setKyuShichosonCode(new LasdecCode(entity.getKyuShichosonCode().getColumnValue().toString()));

//        copy.setSaikofuKubun(new RString(entity.getSaikofuKubun().toString()));
//        copy.setSaikofuJiyuCode(new RString(entity.getSaikofuJiyuCode().toString()));
//        copy.setChohyoKofuRirekiID(new RString(entity.getChohyoKofuRirekiID().toString()));
        return copy;
    }

    private List<KeyValueDataSource> getCode(CodeShubetsu codeShubetsu) {

        List<UzT0007CodeEntity> codeValueList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, codeShubetsu);

        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));

        for (UzT0007CodeEntity codeValueObject : codeValueList) {
            dataSourceList.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード名称()));
        }
        return dataSourceList;
    }

    /**
     * 画面に初期化表示制御
     *
     * @param IJushochiTokureiRirekiListDiv iJushochiTokureiRirekiListDiv
     */
    private void initBtnDisplay() {

        if (JushochiTokureiRirekiListDiv.DisplayType.shokai.equals(jutokuRirekiDiv.getMode_DisplayType())) {
            jutokuRirekiDiv.getBtnAdd().setVisible(false);
            jutokuRirekiDiv.getBtnJutokuKakutei().setVisible(false);
            jutokuRirekiDiv.getBtnJutokuTorikeshi().setVisible(false);
            jutokuRirekiDiv.getJutokuKaijoInput().setDisabled(true);
            jutokuRirekiDiv.getJutokuTekiyoInput().setDisabled(true);
        } else if (JushochiTokureiRirekiListDiv.DisplayType.tekiyo.equals(jutokuRirekiDiv.getMode_DisplayType())) {
            jutokuRirekiDiv.getJutokuKaijoInput().setDisplayNone(true);
        } else if (JushochiTokureiRirekiListDiv.DisplayType.kaijo.equals(jutokuRirekiDiv.getMode_DisplayType())) {
            jutokuRirekiDiv.getJutokuTekiyoInput().setDisplayNone(true);
        }
    }
}
