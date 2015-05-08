/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.DBXCodeShubetsu;
import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.business.util.CodeMasterToKeyValueFunction;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.util.Lists;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoCondition;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModelComparators;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.realservice.KijunTsukiShichosonFinder;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.atenashokaisimple.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ur.urz.definition.code.CodeMasterHelper;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeValueObject;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.URZCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 共有子Div「住所地特例履歴」の状態を変更するクラスです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiRirekiListHandler {

    private final JushochiTokureiRirekiListDiv jutokuRirekiDiv;
    private static final RString PANEL_SESSION_ACCESSOR_KEY = new RString("jushochiTokureiRireki");
    private static final RString PANEL_SESSION_ACCESSOR_EDITING_KEY = new RString("jushochiTokureiRireki_Editing");
    private static final RString SESSION_KYU_HOKENSHA = new RString("kyuHokensha");

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
        JushochiTokureiExecutionStatus jutokuExeStatus
                = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());

        switch (jutokuExeStatus) {
            case Tekiyo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoInput);
                break;
            case Kaijo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoInput);
                break;
            case Teisei:
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
        JushochiTokureiExecutionStatus jutokuExeStatus
                = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());

        switch (jutokuExeStatus) {
            case Tekiyo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoShokai);
                break;
            case Kaijo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoShokai);
                break;
            case Teisei:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiShokai);
                break;
            default:
                break;
        }
        jutokuRirekiDiv.setMode_HokenshaJohoDisplayMode(jutokuRirekiDiv.getMode_HokenshaJohoDisplayMode());
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

        final FlexibleDate conditionDate = row.getTekiyoDate().getValue();
        IPredicate condition = new IPredicate<HihokenshaDaichoModel>() {
            @Override
            public boolean evaluate(HihokenshaDaichoModel targetModel) {
                return conditionDate.equals(targetModel.get適用年月日());
            }
        };

        IItemList<HihokenshaDaichoModel> jutokuList = new HihokenshaDaichoList(getEditing被保険者台帳情報()).to住所地特例List();
        IItemList<HihokenshaDaichoModel> jutokuOneSeason = jutokuList.filter(condition);

        for (HihokenshaDaichoModel model : jutokuOneSeason) {
            if (model.get解除年月日().isEmpty()) {
                setTekiyoInputMeisai(model);
            } else {
                setKaijoInputMeisai(model);
            }
        }
    }

    private void setTekiyoInputMeisai(HihokenshaDaichoModel model) {
        jutokuRirekiDiv.getJutokuTekiyoInput().setTekiyojiShichosonCode(model.get市町村コード().getColumnValue());
        jutokuRirekiDiv.getJutokuTekiyoInput().setTekiyojiHihokenshaNo(model.get被保険者番号().getColumnValue());
        jutokuRirekiDiv.getJutokuTekiyoInput().setTekiyojiShoriDatetime(toRStringForYMDHMS(model.get処理日時().getColumnValue()));

        jutokuRirekiDiv.getTxtTekiyoDate().setValue(model.get適用年月日());
        jutokuRirekiDiv.getTxtTekiyoTodokedeDate().setValue(model.get適用届出年月日());
        jutokuRirekiDiv.getDdlTekiyoJiyu().setSelectedKey(model.get住所地特例適用事由().getCode());
        jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().setSelectedKey(model.get広住特措置元市町村コード().value());
        jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedKey(model.get旧市町村コード().value());
        //TODO n8178 城間篤人 宛名データの取得方を考える（DBから？宛名情報を引数から受け取って？）。とりあえず後で。 2014年12月11日まで
        //最初に一回だけ取得できればよいか？　もしそれでよいならば、ここでの反映するのは、識別コードと市町村コードを比較して対応する値を取得するプライベートメソッドで行う。
        jutokuRirekiDiv.getDdlTekiyojiJuminJoho();
    }

    private RString toRStringForYMDHMS(YMDHMS ymdhms) {
        RStringBuilder builder = new RStringBuilder();
        int year = ymdhms.getRDateTime().getYear();
        int month = ymdhms.getRDateTime().getMonthOfYear();
        int day = ymdhms.getRDateTime().getDayOfMonth();
        int hour = ymdhms.getRDateTime().getHour();
        int minute = ymdhms.getRDateTime().getMinute();
        int second = ymdhms.getRDateTime().getSecond();
        builder.append(new RString(String.valueOf(year)).padZeroToLeft(4));
        builder.append(new RString(String.valueOf(month)).padZeroToLeft(2));
        builder.append(new RString(String.valueOf(day)).padZeroToLeft(2));
        builder.append(new RString(String.valueOf(hour)).padZeroToLeft(2));
        builder.append(new RString(String.valueOf(minute)).padZeroToLeft(2));
        builder.append(new RString(String.valueOf(second)).padZeroToLeft(2));
        return builder.toRString();
    }

    private void setKaijoInputMeisai(HihokenshaDaichoModel model) {
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiShichosonCode(model.get市町村コード().getColumnValue());
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiHihokenshaNo(model.get被保険者番号().getColumnValue());
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiShoriDatetime(toRStringForYMDHMS(model.get処理日時().getColumnValue()));

        jutokuRirekiDiv.getTxtKaijoDate().setValue(model.get解除年月日());
        jutokuRirekiDiv.getTxtKaijoTodokedeDate().setValue(model.get解除届出年月日());
        jutokuRirekiDiv.getDdlKaijoJiyu().setSelectedKey(model.get住所地特例解除事由().getCode());
        jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().setSelectedKey(model.get広住特措置元市町村コード().getColumnValue());
        jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setSelectedKey(model.get旧市町村コード().getColumnValue());
        //TODO n8178 城間篤人 宛名データの取得方を考える（DBから？宛名情報を引数から受け取って？）。とりあえず後で。 2014年12月11日まで
        //最初に一回だけ取得できればよいか？　もしそれでよいならば、ここでの反映するのは、識別コードと市町村コードを比較して対応する値を取得するプライベートメソッドで行う。
        jutokuRirekiDiv.getDdlKaijojiJuminJono();
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
        jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().setSelectedIndex(0);
        jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedIndex(0);
        jutokuRirekiDiv.getDdlTekiyojiJuminJoho().setDataSource(Lists.newArrayList(new KeyValueDataSource()));

        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiShichosonCode(RString.EMPTY);
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiHihokenshaNo(RString.EMPTY);
        jutokuRirekiDiv.getJutokuKaijoInput().setKaijojiShoriDatetime(RString.EMPTY);

        jutokuRirekiDiv.getTxtKaijoDate().setValue(FlexibleDate.EMPTY);
        jutokuRirekiDiv.getTxtKaijoTodokedeDate().setValue(FlexibleDate.EMPTY);
        jutokuRirekiDiv.getDdlKaijoJiyu().setSelectedIndex(0);
        jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().setSelectedIndex(0);
        jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setSelectedIndex(0);
        jutokuRirekiDiv.getDdlKaijojiJuminJono().setDataSource(Lists.newArrayList(new KeyValueDataSource()));

    }

    /**
     * Divに登録されている被保険者台帳Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> get被保険者台帳情報() {
        IItemList<HihokenshaDaichoModel> 被保険者台帳List
                = ItemList.of(PanelSessionAccessor.get(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, ArrayList.class));
        return 被保険者台帳List;
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
     * Divに登録されている変更前後の履歴をマージすることで、更新処理などで利用可能な履歴を作成して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> getUpdate被保険者台帳情報() {
        IItemList<HihokenshaDaichoModel> baseList
                = ItemList.of(PanelSessionAccessor.get(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, ArrayList.class));
        IItemList<HihokenshaDaichoModel> editingList
                = ItemList.of(PanelSessionAccessor.get(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_EDITING_KEY, ArrayList.class));
        return merge(baseList, editingList);
    }

    private IItemList<HihokenshaDaichoModel> merge(IItemList<HihokenshaDaichoModel> baseList, IItemList<HihokenshaDaichoModel> editingList) {

        List<HihokenshaDaichoModel> mergedList = new ArrayList<>();

        for (HihokenshaDaichoModel editingModel : editingList) {
            IPredicate condition = new HihokenshaDaichoCondition(editingModel);
            IItemList<HihokenshaDaichoModel> justOneList = baseList.filter(condition);

            if (justOneList.isEmpty()) {
                mergedList.add(editingModel);
                continue;
            }

            HihokenshaDaichoModel baseModel = justOneList.findJustOne().get();
            if (editingModel.getState().equals(baseModel.getState())) {
                mergedList.add(editingModel);
                continue;
            }

            switch (editingModel.getState()) {
                case Modified:
                    HihokenshaDaichoModel addingModel = new HihokenshaDaichoModel(editingModel.getEntity());
                    addingModel.get処理日時().plusSeconds(1);
                    mergedList.add(addingModel);
                case Deleted:
                    baseModel.setDeletedState(true);
                    mergedList.add(baseModel);
                    break;
                default:
                    break;
            }

        }
        return ItemList.of(mergedList);
    }

    /**
     * 引数から受け取った被保険者台帳Listの情報をDivに登録します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    public void set被保険者台帳情報(IItemList<HihokenshaDaichoModel> 被保険者台帳List) {
        PanelSessionAccessor.put(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, (ArrayList) 被保険者台帳List.toList());
        PanelSessionAccessor.put(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_EDITING_KEY, (ArrayList) 被保険者台帳List.toList());
    }

    /**
     * 引数から受け取った被保険者台帳Listの情報をDivに登録します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    private void setEditing被保険者台帳情報(IItemList<HihokenshaDaichoModel> 被保険者台帳List) {
        PanelSessionAccessor.put(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_EDITING_KEY, (ArrayList) 被保険者台帳List.toList());
    }

    /**
     * Divに登録されている被保険者台帳情報から、住所地特例についての情報を抽出してグリッドにマッピングします。
     */
    public void mapping住所地特例履歴() {
        IItemList<HihokenshaDaichoModel> 被保険者台帳List = getEditing被保険者台帳情報();
        IItemList<HihokenshaDaichoModel> 住所地特例List = new HihokenshaDaichoList(被保険者台帳List).to住所地特例List();

        List<dgJutoku_Row> dataSource = new ArrayList<>();
        for (HihokenshaDaichoModel model : 住所地特例List) {
            dataSource.add(createRow(model));
        }
        jutokuRirekiDiv.getDgJutoku().setDataSource(dataSource);
    }

    private dgJutoku_Row createRow(HihokenshaDaichoModel model) {
        dgJutoku_Row row = new dgJutoku_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxDate());

        setRowState(row, model);
        row.setShichosonCode(model.get市町村コード().getColumnValue());
        row.setHihokenshaNo(model.get被保険者番号().getColumnValue());
        row.setShoriTimestamp(toRStringForYMDHMS(model.get処理日時().getColumnValue()));
        row.getTekiyoDate().setValue(model.get適用年月日());
        row.getTekiyoTodokedeDate().setValue(model.get適用届出年月日());
        row.setTekiyoJiyuKey(model.get住所地特例適用事由().getName());
        row.setTekiyoJiyu(model.get住所地特例適用事由().getShortName());
        row.getKaijoDate().setValue(model.get解除年月日());
        row.getKaijoTodokedeDate().setValue(model.get解除届出年月日());
        if (model.getEntity().getJushochitokureiKaijoJiyuCode() == null
                || !model.getEntity().getJushochitokureiKaijoJiyuCode().getColumnValue().isEmpty()) {
            row.setKaijoJiyuKey(model.get住所地特例解除事由().getName());
            row.setKaijoJiyu(model.get住所地特例解除事由().getShortName());
        }
        row.setSochimotoHokensha(model.get広住特措置元市町村コード().getColumnValue());
        row.setKyuHokensha(getKyuHokenshaName(model.get旧市町村コード()));
        if (model.getEntity().getLastUpdateTimestamp() != null) {
            row.getShoriDate().setValue((model.getEntity().getLastUpdateTimestamp().getDate()));
        }
        return row;
    }

    private void setKyuHokensya(LasdecCode lasdecCode) {

        KijunTsukiShichosonFinder finder = new KijunTsukiShichosonFinder();
        Optional<GappeiShichosonJohoModel> gappeiInfo = finder.get基準月市町村情報(FlexibleDate.getNowDate().getYearMonth(), lasdecCode);
        if (gappeiInfo.isPresent()) {
            PanelSessionAccessor.put(jutokuRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.newItemList(gappeiInfo.get().get単一市町村情報()));
        } else {
            PanelSessionAccessor.put(jutokuRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.empty());
        }
    }

    private List<KeyValueDataSource> getKyuHokensyaKeyValueDataSource() {

        switch (jutokuRirekiDiv.getMode_HokenshaJohoDisplayMode()) {
            case KoikiGappeiNashi:
            case TanitsuGappeiNashi:
                return Collections.<KeyValueDataSource>emptyList();
        }

        IItemList<IGappeiShichoson> kyuHokenshaList
                = PanelSessionAccessor.get(jutokuRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.class);

        IFunction<IGappeiShichoson, KeyValueDataSource> predicate = new IFunction<IGappeiShichoson, KeyValueDataSource>() {
            @Override
            public KeyValueDataSource apply(IGappeiShichoson target) {
                return new KeyValueDataSource(target.get旧市町村コード().getColumnValue(), target.get旧市町村名称());
            }
        };

        return kyuHokenshaList.map(predicate).toList();
    }

    private RString getKyuHokenshaName(final LasdecCode lasdecCode) {

        switch (jutokuRirekiDiv.getMode_HokenshaJohoDisplayMode()) {
            case KoikiGappeiNashi:
            case TanitsuGappeiNashi:
                return RString.EMPTY;
        }

        IItemList<IGappeiShichoson> kyuHokenshaList
                = PanelSessionAccessor.get(jutokuRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.class);

        IPredicate<IGappeiShichoson> predicate = new IPredicate<IGappeiShichoson>() {
            @Override
            public boolean evaluate(IGappeiShichoson t) {
                return t.get旧市町村コード().equals(lasdecCode);
            }
        };

        IItemList<IGappeiShichoson> kyuHokensha = kyuHokenshaList.filter(predicate);
        if (kyuHokensha.isJustOne() && kyuHokensha.findFirst().isPresent()) {
            return kyuHokensha.findJustOne().get().get旧市町村名称();
        } else {
            return RString.EMPTY;
        }
    }

    private void setRowState(dgJutoku_Row row, HihokenshaDaichoModel model) {

        RString stateString;
        RowState state;
        switch (model.getState()) {
            case Added:
                stateString = new RString("追加");
                state = RowState.Added;
                break;
            case Modified:
                stateString = new RString("修正");
                state = RowState.Modified;
                break;
            case Deleted:
                stateString = new RString("削除");
                state = RowState.Deleted;
                break;
            default:
                stateString = new RString("");
                state = RowState.Unchanged;
                break;
        }

        row.setState(stateString);
        row.setRowState(state);
    }

    /**
     * 明細パネルに入力されている情報を元に、自身の持つ被保険者台帳履歴を更新します。
     */
    public void updateEntryData() {

        switch (ViewExecutionStatus.toValue(jutokuRirekiDiv.getExecutionStatus())) {
            case Add:
                addEntryData();
                break;
            case Modify:
                modifyEntryData();
                break;
            case Delete:
                deleteEntryData();
                break;
        }
    }

    private void addEntryData() {

        Optional<HihokenshaDaichoModel> baseDataModel;
        IItemList<HihokenshaDaichoModel> sorted被保険者台帳履歴
                = getEditing被保険者台帳情報().sorted(HihokenshaDaichoModelComparators.orderBy処理日時.desc());
        HihokenshaDaichoModel mergedTekiyoModel;
        HihokenshaDaichoModel mergedKaijoModel;
        HihokenshaDaichoModel addTekiyoModel = new HihokenshaDaichoModel();
        HihokenshaDaichoModel addKaijoModel = new HihokenshaDaichoModel();

        JushochiTokureiExecutionStatus jutokuExeStatus = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());
        switch (jutokuExeStatus) {
            case Tekiyo:
                baseDataModel = sorted被保険者台帳履歴.findFirst();
                DbT1001HihokenshaDaichoEntity entity = deepCopy(baseDataModel.get().getEntity());
                mergedTekiyoModel = mergeTekiyoMeisai(new HihokenshaDaichoModel(entity));
                mergedTekiyoModel.set処理日時(ShoriTimestamp.of(
                        RDateTime.of(
                                mergedTekiyoModel.get適用年月日().getYearValue(),
                                mergedTekiyoModel.get適用年月日().getMonthValue(),
                                mergedTekiyoModel.get適用年月日().getDayValue(),
                                0, 0)));
                addTekiyoModel.getEntity().shallowCopy(mergedTekiyoModel.getEntity());
                setEditing被保険者台帳情報(sorted被保険者台帳履歴.added(addTekiyoModel));
                break;
            case Kaijo:
                baseDataModel = sorted被保険者台帳履歴.findFirst();
                mergedKaijoModel = mergedKaijoMeisai(new HihokenshaDaichoModel(baseDataModel.get().getEntity()));
                mergedKaijoModel.set処理日時(ShoriTimestamp.of(
                        RDateTime.of(
                                mergedKaijoModel.get解除年月日().getYearValue(),
                                mergedKaijoModel.get解除年月日().getMonthValue(),
                                mergedKaijoModel.get解除年月日().getDayValue(),
                                0, 0)));
                addKaijoModel.getEntity().shallowCopy(mergedKaijoModel.getEntity());
                setEditing被保険者台帳情報(sorted被保険者台帳履歴.added(addKaijoModel));
                break;
            case Teisei:
            default:
                baseDataModel = Optional.of(getPreviousInputTekiyoDateBy(sorted被保険者台帳履歴));
                mergedTekiyoModel = mergeTekiyoMeisai(new HihokenshaDaichoModel(baseDataModel.get().getEntity()));
                mergedTekiyoModel.set処理日時(ShoriTimestamp.of(
                        RDateTime.of(
                                mergedTekiyoModel.get適用年月日().getYearValue(),
                                mergedTekiyoModel.get適用年月日().getMonthValue(),
                                mergedTekiyoModel.get適用年月日().getDayValue(),
                                0, 0)));
                addTekiyoModel.getEntity().shallowCopy(mergedTekiyoModel.getEntity());
                mergedKaijoModel = mergedKaijoMeisai(mergedTekiyoModel);
                mergedKaijoModel.set処理日時(ShoriTimestamp.of(
                        RDateTime.of(
                                mergedKaijoModel.get解除年月日().getYearValue(),
                                mergedKaijoModel.get解除年月日().getMonthValue(),
                                mergedKaijoModel.get解除年月日().getDayValue(),
                                0, 0)));
                addKaijoModel.getEntity().shallowCopy(mergedKaijoModel.getEntity());
                setEditing被保険者台帳情報(sorted被保険者台帳履歴.added(addTekiyoModel, addKaijoModel));
                break;
        }
    }

    private void modifyEntryData() {

        IItemList<HihokenshaDaichoModel> sorted被保険者台帳履歴
                = getEditing被保険者台帳情報().sorted(HihokenshaDaichoModelComparators.orderBy処理日時.desc());
        List<HihokenshaDaichoModel> sortedList = sorted被保険者台帳履歴.toList();
        HihokenshaDaichoModel mergedTekiyoModel;
        HihokenshaDaichoModel mergedKaijoModel;

        JushochiTokureiExecutionStatus jutokuExeStatus = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());
        switch (jutokuExeStatus) {
            case Tekiyo:
                mergeTekiyoMeisai(sortedList.get(0));
                setEditing被保険者台帳情報(sorted被保険者台帳履歴);
                break;
            case Kaijo:
                mergedKaijoMeisai(sortedList.get(0));
                setEditing被保険者台帳情報(sorted被保険者台帳履歴);
                break;
            case Teisei:
            default:
                mergedTekiyoModel = mergeTekiyoMeisai(sortedList.get(0));
                mergedKaijoModel = mergedKaijoMeisai(mergedTekiyoModel);
                setEditing被保険者台帳情報(sorted被保険者台帳履歴.added(mergedTekiyoModel, mergedKaijoModel));
                break;
        }
    }

    private void deleteEntryData() {
        IItemList<HihokenshaDaichoModel> sorted被保険者台帳履歴
                = getEditing被保険者台帳情報().sorted(HihokenshaDaichoModelComparators.orderBy処理日時.desc());
        List<HihokenshaDaichoModel> sortedList = sorted被保険者台帳履歴.toList();
        HihokenshaDaichoModel deleteModel;

        deleteModel = sortedList.get(0);
        deleteModel.setDeletedState(true);
        sortedList.set(0, deleteModel);
        setEditing被保険者台帳情報(ItemList.of(sortedList));
    }

    //TODO n8178 城間篤人 自身のひとつ前の履歴を探す処理だが、問題がありそう？ 生産性では適用登録のみに焦点を置くが、後日確認の必要がある。
    private HihokenshaDaichoModel getPreviousInputTekiyoDateBy(IItemList<HihokenshaDaichoModel> itemList) {

        List<HihokenshaDaichoModel> list = itemList.toList();
        FlexibleDate tekiyoDate = jutokuRirekiDiv.getTxtTekiyoDate().getValue();
        RDateTime dateTime = RDateTime.of(tekiyoDate.getYearValue(), tekiyoDate.getMonthValue(), tekiyoDate.getDayValue(), 0, 0);
        ShoriTimestamp tekiyoDateShoriTime = ShoriTimestamp.of(dateTime);

        for (HihokenshaDaichoModel model : list) {
            if (model.get処理日時().getColumnValue().isBeforeOrEquals(tekiyoDateShoriTime.getColumnValue())) {
                return model;
            }
        }
        return null;
    }

    private HihokenshaDaichoModel mergeTekiyoMeisai(HihokenshaDaichoModel mergedModel) {

        mergedModel.set適用年月日(jutokuRirekiDiv.getTxtTekiyoDate().getValue());
        mergedModel.set適用届出年月日(jutokuRirekiDiv.getTxtTekiyoTodokedeDate().getValue());
        mergedModel.set住所地特例適用事由(JushochitokureiTekiyoJiyu.toValue(jutokuRirekiDiv.getDdlTekiyoJiyu().getSelectedKey()));
        mergedModel.set広住特措置元市町村コード(new LasdecCode(jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().getSelectedKey()));
        mergedModel.set旧市町村コード(new LasdecCode(jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().getSelectedKey()));

        return mergedModel;
    }

    private HihokenshaDaichoModel mergedKaijoMeisai(HihokenshaDaichoModel mergedModel) {
        //TODO n8178 城間篤人 住民情報に変更がある場合trueになる処理を記述する必要があるが、広域対応のため後日実装する。 2015年3月
        if (false) {
            mergedModel.set市町村コード(new LasdecCode("209007"));
            mergedModel.set識別コード(new ShikibetsuCode("000090000900009"));
        }

        mergedModel.set解除年月日(jutokuRirekiDiv.getTxtKaijoDate().getValue());
        mergedModel.set解除届出年月日(jutokuRirekiDiv.getTxtKaijoTodokedeDate().getValue());
        mergedModel.set住所地特例解除事由(JushochitokureiKaijoJiyu.toValue(jutokuRirekiDiv.getDdlKaijoJiyu().getSelectedKey()));
        mergedModel.set広住特措置元市町村コード(new LasdecCode(jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().getSelectedKey()));
        mergedModel.set旧市町村コード(new LasdecCode(jutokuRirekiDiv.getDdlKaijojiKyuHokensha().getSelectedKey()));
        return mergedModel;
    }

    /**
     * 明細パネルに入力されている情報をModelに変換して返します。
     *
     * @return 明細パネルに入力されている情報を元に生成した被保険者台帳Model
     */
    public Optional<HihokenshaDaichoModel> createEntryData() {

        Optional<HihokenshaDaichoModel> baseDataModel;
        IItemList<HihokenshaDaichoModel> sorted被保険者台帳履歴
                = getEditing被保険者台帳情報().sorted(HihokenshaDaichoModelComparators.orderBy処理日時.desc());

        JushochiTokureiExecutionStatus jutokuExeStatus = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());
        switch (jutokuExeStatus) {
            case Tekiyo:
                baseDataModel = sorted被保険者台帳履歴.findFirst();
                return Optional.of(mergeTekiyoMeisai(baseDataModel.get()));
            case Kaijo:
                baseDataModel = sorted被保険者台帳履歴.findFirst();
                return Optional.of(mergedKaijoMeisai(baseDataModel.get()));
            case Teisei:
            default:
                baseDataModel = Optional.of(getPreviousInputTekiyoDateBy(sorted被保険者台帳履歴));
                HihokenshaDaichoModel mergedTekiyoModel = mergeTekiyoMeisai(baseDataModel.get());
                return Optional.of(mergedKaijoMeisai(mergedTekiyoModel));
        }
    }

    /**
     * 明細パネルが変更されたかどうかを判定します。 <br/>
     * 追加を行う場合は、明細行の内容が全て空白で無ければtrueを返します。<br/>
     * 修正を行う場合は、明細行の内容が書き換えられている場合にtrueを返します。
     *
     * @return 明細パネルの内容が変更されていたらtrue
     */
    public boolean hasChangedInMeisai() {
        JushochiTokureiExecutionStatus jutokuExeStatus
                = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());
        ViewExecutionStatus exeStatus = ViewExecutionStatus.toValue(jutokuRirekiDiv.getExecutionStatus());

        if (exeStatus == ViewExecutionStatus.Add) {
            return !equalsMeisaiToEmpty();
        }

        switch (jutokuExeStatus) {
            case Tekiyo:
                return !equalsMeisai(findTekiyoMeisaiOriginModel());
            case Kaijo:
                return !equalsMeisai(findKaijoMeisaiOriginModel());
            case Teisei:
            default:
                return !(equalsMeisai(findTekiyoMeisaiOriginModel())
                        && equalsMeisai(findKaijoMeisaiOriginModel()));
        }
    }

    private boolean equalsMeisaiToEmpty() {

        if (!jutokuRirekiDiv.getTxtTekiyoDate().getValue().equals(FlexibleDate.EMPTY)) {
            return false;
        }
        if (!jutokuRirekiDiv.getTxtTekiyoTodokedeDate().getValue().equals(FlexibleDate.EMPTY)) {
            return false;
        }
        if (jutokuRirekiDiv.getDdlTekiyoJiyu().getSelectedIndex() != 0) {
            return false;
        }
        if (jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().getSelectedIndex() != 0) {
            return false;
        }
        if (jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().getSelectedIndex() != 0) {
            return false;
        }

        if (!jutokuRirekiDiv.getTxtKaijoDate().getValue().equals(FlexibleDate.EMPTY)) {
            return false;
        }
        if (!jutokuRirekiDiv.getTxtKaijoTodokedeDate().getValue().equals(FlexibleDate.EMPTY)) {
            return false;
        }
        if (jutokuRirekiDiv.getDdlKaijoJiyu().getSelectedIndex() != 0) {
            return false;
        }
        if (jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().getSelectedIndex() != 0) {
            return false;
        }

        return jutokuRirekiDiv.getDdlKaijojiKyuHokensha().getSelectedIndex() != 0;
    }

    private boolean equalsMeisai(HihokenshaDaichoModel targetModel) {

        if (!targetModel.get適用年月日().equals(jutokuRirekiDiv.getTxtTekiyoDate().getValue())) {
            return false;
        }
        if (!targetModel.get適用届出年月日().equals(jutokuRirekiDiv.getTxtTekiyoTodokedeDate().getValue())) {
            return false;
        }
        if (!targetModel.get住所地特例適用事由().equals(new KaigoShikakuJutokuTekiyoJiyu(jutokuRirekiDiv.getDdlTekiyoJiyu().getSelectedKey()))) {
            return false;
        }
        if (!targetModel.get広住特措置元市町村コード().equals(new LasdecCode(jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().getSelectedKey()))) {
            return false;
        }
        if (!targetModel.get旧市町村コード().equals(new LasdecCode(jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().getSelectedKey()))) {
            return false;
        }

        if (!targetModel.get解除年月日().equals(jutokuRirekiDiv.getTxtKaijoDate().getValue())) {
            return false;
        }
        if (!targetModel.get解除届出年月日().equals(jutokuRirekiDiv.getTxtKaijoTodokedeDate().getValue())) {
            return false;
        }
        if (!targetModel.get住所地特例解除事由().equals(new KaigoShikakuJutokuKaijoJiyu(jutokuRirekiDiv.getDdlKaijoJiyu().getSelectedKey()))) {
            return false;
        }
        if (!targetModel.get広住特措置元市町村コード().equals(new LasdecCode(jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().getSelectedKey()))) {
            return false;
        }

        return targetModel.get旧市町村コード().equals(new LasdecCode(jutokuRirekiDiv.getDdlKaijojiKyuHokensha().getSelectedKey()));
    }

    private HihokenshaDaichoModel findTekiyoMeisaiOriginModel() {
        LasdecCode 市町村コード = new LasdecCode(jutokuRirekiDiv.getJutokuTekiyoInput().getTekiyojiShichosonCode());
        HihokenshaNo 被保険者番号 = new HihokenshaNo(jutokuRirekiDiv.getJutokuTekiyoInput().getTekiyojiHihokenshaNo());
        ShoriTimestamp 処理日時 = ShoriTimestamp.of(new YMDHMS(jutokuRirekiDiv.getJutokuTekiyoInput().getTekiyojiShoriDatetime()));
        IPredicate<HihokenshaDaichoModel> condition = new HihokenshaDaichoCondition(市町村コード, 被保険者番号, 処理日時);
        return getEditing被保険者台帳情報().filter(condition).findJustOne().get();
    }

    private HihokenshaDaichoModel findKaijoMeisaiOriginModel() {
        LasdecCode 市町村コード = new LasdecCode(jutokuRirekiDiv.getJutokuKaijoInput().getKaijojiShichosonCode());
        HihokenshaNo 被保険者番号 = new HihokenshaNo(jutokuRirekiDiv.getJutokuKaijoInput().getKaijojiHihokenshaNo());
        ShoriTimestamp 処理日時 = ShoriTimestamp.of(new YMDHMS(jutokuRirekiDiv.getJutokuKaijoInput().getKaijojiShoriDatetime()));
        IPredicate<HihokenshaDaichoModel> condition = new HihokenshaDaichoCondition(市町村コード, 被保険者番号, 処理日時);
        return getEditing被保険者台帳情報().filter(condition).findJustOne().get();
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param kyuShichosonCode 旧市町村コード
     * @param exeStatus 実行ステータス。Add・Delete・Modifyのうちのいずれかを設定する。
     * @param jutokuExeStatsu
     * 住所地特例実行ステータス。実行ステータス（Add・Delete・Modify）とは別に、Tekiyo・Kaijo・Teisei・Shokaiのうちのいずれかを設定する。
     * @param hokenshaJohoDisplayMode 明細表示モード
     */
    public void initialize(LasdecCode kyuShichosonCode, ViewExecutionStatus exeStatus, JushochiTokureiExecutionStatus jutokuExeStatsu,
            JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode hokenshaJohoDisplayMode) {
        jutokuRirekiDiv.setExecutionStatus(exeStatus.getValue());
        jutokuRirekiDiv.setJushochiTokureiExecutionState(jutokuExeStatsu.getValue());

        switch (hokenshaJohoDisplayMode) {
            case TanitsuGappeiAri:
            case KoikiGappeiAri:
                setKyuHokensya(kyuShichosonCode);
                break;
        }

        jutokuRirekiDiv.setMode_HokenshaJohoDisplayMode(hokenshaJohoDisplayMode);
        setTekiyoJiyuDataSource();
        setKaijoJiyuDataSource();
        setShichosonJohoDataSource(kyuShichosonCode);
        setJuminJohoDataSource();
    }

    private void setTekiyoJiyuDataSource() {
        List<KaigoShikakuHenkoJiyu> tekiyoList = CodeMasterHelper.getCode(DBXCodeShubetsu.介護資格住特適用事由);
        IItemList<KeyValueDataSource> dataSource = ItemList.of(tekiyoList).map(new CodeMasterToKeyValueFunction());
        jutokuRirekiDiv.getDdlTekiyoJiyu().setDataSource(dataSource.toList());
    }

    private void setKaijoJiyuDataSource() {
        List<KaigoShikakuJutokuKaijoJiyu> kaijoList = CodeMasterHelper.getCode(DBXCodeShubetsu.介護資格住特解除事由);
        IItemList<KeyValueDataSource> dataSource = ItemList.of(kaijoList).map(new CodeMasterToKeyValueFunction());
        jutokuRirekiDiv.getDdlKaijoJiyu().setDataSource(dataSource.toList());
    }

    private void setShichosonJohoDataSource(LasdecCode kyuLasdecCode) {
        List<KeyValueDataSource> kyuShichosonDataSource = getKyuHokensyaKeyValueDataSource();
        jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setDataSource(kyuShichosonDataSource);
        jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setDataSource(kyuShichosonDataSource);

        if (kyuLasdecCode == null || kyuLasdecCode.isEmpty()) {
            jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedIndex(0);
            jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedIndex(0);
        } else {
            jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedKey(kyuLasdecCode.getColumnValue());
            jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setSelectedKey(kyuLasdecCode.getColumnValue());
        }
        jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setDisabled(true);
        jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setDisabled(true);

        //TODO n8178 城間篤人 広域対応時に修正が必要。
        List<LasdecCode> koikiShochosonJohoList = Collections.<LasdecCode>emptyList();
        List<KeyValueDataSource> koikiShichosonDataSource = creaateShichosonKeyValue(koikiShochosonJohoList);
        jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().setDataSource(koikiShichosonDataSource);
        jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().setDataSource(koikiShichosonDataSource);
    }

    private void setJuminJohoDataSource() {
        //TODO n8178 城間篤人 JuminJohoCreatorからListを受け取る。明日の朝まで。
        List<RString> juminJohoList = Collections.<RString>emptyList();
        List<KeyValueDataSource> juminJohoDataSource = creaateRStringKeyValue(juminJohoList);
        jutokuRirekiDiv.getDdlTekiyojiJuminJoho().setDataSource(juminJohoDataSource);
        jutokuRirekiDiv.getDdlKaijojiJuminJono().setDataSource(juminJohoDataSource);
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
     * </ul>
     */
    public void setupToBeforeInput() {
        jutokuRirekiDiv.getBtnAdd().setDisabled(true);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(true);
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
        for (HihokenshaDaichoModel daicho : daichoList) {
            if (daicho.getState() == EntityDataState.Unchanged) {
                continue;
            }
            return true;
        }
        return false;
    }

    private DbT1001HihokenshaDaichoEntity deepCopy(DbT1001HihokenshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity copy = new DbT1001HihokenshaDaichoEntity();

        copy.setShichosonCode(new LasdecCode(entity.getShichosonCode().getColumnValue().toString()));
        copy.setHihokenshaNo(new HihokenshaNo(new RString(entity.getHihokenshaNo().getColumnValue().toString())));
        RDateTime copyDateTime = entity.getShoriTimestamp().getColumnValue().getRDateTime();
        copy.setShoriTimestamp(ShoriTimestamp.of(
                RDateTime.of(copyDateTime.getYear(), copyDateTime.getMonth(), copyDateTime.getDayOfMonth(),
                        copyDateTime.getHour(), copyDateTime.getMinute(), copyDateTime.getSecond())
        ));
        copy.setShikibetsuCode(new ShikibetsuCode(entity.getShikibetsuCode().getColumnValue().toString()));

        copy.setShikakuShutokuJiyuCode(new KaigoShikakuShutokuJiyu(new Code(entity.getShikakuShutokuJiyuCode().getColumnValue().toString())));
        copy.setShikakuShutokuYMD(new FlexibleDate(entity.getShikakuShutokuYMD().toString()));
        copy.setShikakuShutokuTodokedeYMD(new FlexibleDate(entity.getShikakuShutokuTodokedeYMD().toString()));

        copy.setIchigoShikakuShutokuYMD(new FlexibleDate(entity.getIchigoShikakuShutokuYMD().toString()));
        copy.setHihokennshaKubunCode(new RString(entity.getHihokennshaKubunCode().toString()));

        copy.setShikakuSoshitsuJiyuCode(new KaigoShikakuSoshitsuJiyu(new Code(entity.getShikakuSoshitsuJiyuCode().getColumnValue().toString())));
        copy.setShikakuSoshitsuYMD(new FlexibleDate(entity.getShikakuSoshitsuYMD().toString()));
        copy.setShikakuSoshitsuTodokedeYMD(new FlexibleDate(entity.getShikakuSoshitsuTodokedeYMD().toString()));

        copy.setJushochiTokureiFlag(new RString(entity.getJushochiTokureiFlag().toString()));

        copy.setShikakuHenkoJiyuCode(new KaigoShikakuHenkoJiyu(new Code(entity.getShikakuHenkoJiyuCode().getColumnValue().toString())));
        copy.setShikakuHenkoYMD(new FlexibleDate(entity.getShikakuHenkoYMD().toString()));
        copy.setShikakuHenkoTodokedeYMD(new FlexibleDate(entity.getShikakuHenkoTodokedeYMD().toString()));

        copy.setJushochitokureiTekiyoJiyuCode(new KaigoShikakuJutokuTekiyoJiyu(new Code(entity.getJushochitokureiTekiyoJiyuCode().getColumnValue().toString())));
        copy.setJushochitokureiTekiyoYMD(new FlexibleDate(entity.getJushochitokureiTekiyoYMD().toString()));
        copy.setJushochitokureiTekiyoTodokedeYMD(new FlexibleDate(entity.getJushochitokureiTekiyoTodokedeYMD().toString()));

        copy.setJushochitokureiKaijoJiyuCode(new KaigoShikakuJutokuKaijoJiyu(new Code(entity.getJushochitokureiKaijoJiyuCode().getColumnValue().toString())));
        copy.setJushochitokureiKaijoYMD(new FlexibleDate(entity.getJushochitokureiKaijoYMD().toString()));
        copy.setJushochitokureiKaijoTodokedeYMD(new FlexibleDate(entity.getJushochitokureiKaijoTodokedeYMD().toString()));

        copy.setKoikinaiJushochiTokureiFlag(new RString(entity.getKoikinaiJushochiTokureiFlag().toString()));

        copy.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(entity.getKoikinaiTokureiSochimotoShichosonCode().getColumnValue().toString()));
        copy.setKyuShichosonCode(new LasdecCode(entity.getKyuShichosonCode().getColumnValue().toString()));

        copy.setSaikofuKubun(new RString(entity.getSaikofuKubun().toString()));
        copy.setSaikofuJiyuCode(new RString(entity.getSaikofuJiyuCode().toString()));
        copy.setChohyoKofuRirekiID(new RString(entity.getChohyoKofuRirekiID().toString()));
        return copy;
    }

}
