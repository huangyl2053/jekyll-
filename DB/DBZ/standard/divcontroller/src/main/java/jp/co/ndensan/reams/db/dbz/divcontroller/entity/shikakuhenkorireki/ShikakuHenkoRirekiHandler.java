/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokendhaDaichoKey;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModelComparators;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoFinder;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.definition.code.CodeMasterHelper;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeValueObject;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 資格変更履歴共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoRirekiHandler {

    private final ShikakuHenkoRirekiDiv shikakuHenkoRirekiDiv;
    private static final RString SESSION_ACCESSOR_KEY = new RString("shikakuHenkouRireki");
    private static final RString SESSION_ACCESSOR_EDITING_KEY = new RString("shikakuHenkouRireki_Editing");
    private static final int ONE_SECONDS = 1;

    /**
     * コンストラクタです。
     *
     * @param shikakuHenkoRirekiDiv 住所地特例履歴ListDiv
     */
    public ShikakuHenkoRirekiHandler(ShikakuHenkoRirekiDiv shikakuHenkoRirekiDiv) {
        this.shikakuHenkoRirekiDiv = shikakuHenkoRirekiDiv;
    }

    public void load(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        HihokenshaDaichoFinder hihokenshaFinder = new HihokenshaDaichoFinder();
        IItemList<HihokenshaDaichoModel> find被保険者台帳List = hihokenshaFinder.find被保険者台帳List(市町村コード, 被保険者番号);
        set被保険者台帳情報(find被保険者台帳List);
        mapping資格変更履歴();
        setJuminJohoDataSource();
        setHenkoJiyuDataSource();
    }

    public void initialize(LasdecCode 市町村コード) {
        HihokenshaDaichoFinder hihokenshaFinder = new HihokenshaDaichoFinder();
        HihokenshaDaichoList 被保険者List = new HihokenshaDaichoList(hihokenshaFinder.find直近被保険者台帳一覧(市町村コード));
        switch (shikakuHenkoRirekiDiv.getMode_HokenshaJohoDisplayMode()) {

            case TanitsuGappeiNashi:
                shikakuHenkoRirekiDiv.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiNashi);
                break;
            case TanitsuGappeiAri:
                shikakuHenkoRirekiDiv.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
                setTanitsuGappeiAri(被保険者List);
                break;

            case KoikiGappeiNashi:
                shikakuHenkoRirekiDiv.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiNashi);
                setJuminJohoDataSource();
                setKoikiGappeiNashi(被保険者List);
                break;
            case KoikiGappeiAri:
                shikakuHenkoRirekiDiv.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
                setJuminJohoDataSource();
                setKoikiGappeiAri(被保険者List);
                break;
            default:
                break;
        }
        setHenkoJiyuDataSource();
    }

    /**
     * 引数から受け取った被保険者台帳Listの情報をDivに登録します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    public void set被保険者台帳情報(IItemList<HihokenshaDaichoModel> 被保険者台帳List) {
        PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.newItemList(被保険者台帳List));
        PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_EDITING_KEY, ItemList.newItemList(被保険者台帳List));
        被保険者台帳List = 被保険者台帳List.sorted(HihokenshaDaichoModelComparators.orderBy資格変更年月日.desc());
        shikakuHenkoRirekiDiv.getDgHenko().setDataSource(被保険者台帳List.map(ShikakuHenkoMapper.toGridRow()).toList());
    }

    private <T extends ICodeValueObject> List<KeyValueDataSource> createCodeMasterKeyValue(List<T> dataSource) {
        List<KeyValueDataSource> keyValueDataSourceList = new ArrayList<>();
        for (T data : dataSource) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(data.toRString(), data.getMeisho());
            keyValueDataSourceList.add(keyValueDataSource);
        }
        return keyValueDataSourceList;
    }

    private void setHenkoJiyuDataSource() {
        List<KaigoshikakuHenkoJiyuHihokensha> henkoJiyuList = CodeMasterHelper.getCode(URZCodeShubetsu.介護資格変更事由_被保険者);
        shikakuHenkoRirekiDiv.getDdlHenkoJiyu().setDataSource(createCodeMasterKeyValue(henkoJiyuList));
    }

    private void setJuminJohoDataSource() {
        //TODO n8178 城間篤人 JuminJohoCreatorからListを受け取る。明日の朝まで。
        //TODO n8235 船山洋介 宛名の地区コード3の扱いを決める必要あり。1月中に対応
        List<RString> juminJohoList = Collections.<RString>emptyList();
        List<KeyValueDataSource> juminJohoDataSource = createRStringKeyValue(juminJohoList);
        shikakuHenkoRirekiDiv.getDdlJuminJoho().setDataSource(juminJohoDataSource);
    }

    /**
     * Divに登録されている被保険者台帳情報から、資格変更についての情報を抽出してグリッドにマッピングします。
     */
    public void mapping資格変更履歴() {
        IItemList<HihokenshaDaichoModel> 資格異動List = new HihokenshaDaichoList(get被保険者台帳情報()).to資格関連異動List();
        List<dgHenko_Row> dataSource = new ArrayList<>();
        for (HihokenshaDaichoModel model : 資格異動List) {
            dataSource.add(createRow(model));
        }
        shikakuHenkoRirekiDiv.getDgHenko().setDataSource(dataSource);
    }

    private dgHenko_Row createRow(HihokenshaDaichoModel model) {
        dgHenko_Row row = new dgHenko_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate());
        TextBoxFlexibleDate shoriDate = new TextBoxFlexibleDate();
        shoriDate.setValue(new FlexibleDate(model.get処理日時().toDateString()));
        setRowState(row, model);
        row.setShoriDate(shoriDate);
        row.setHenkoJiyuKey(model.get資格変更事由().getCode());
        row.setHenkoJiyu(model.get資格変更事由().getShortName());
        row.getHenkoDate().setValue(model.get資格変更年月日());
        row.getHenkoTodokedeDate().setValue(model.get資格変更届出年月日());
        row.setSochimotoHokensha(model.get広住特措置元市町村コード().getColumnValue());
        row.setKyuHokensha(Kyuhokensha.toValue(model.get旧市町村コード().getColumnValue()).getName());
        if (model.getEntity().getLastUpdateTimestamp() != null) {
            row.getShoriDate().setValue(new FlexibleDate(model.getEntity().getLastUpdateTimestamp().getDate().toDateString()));
        } else {
            row.getShoriDate().setValue(FlexibleDate.getNowDate());
        }
        return row;
    }

    private void setRowState(dgHenko_Row row, HihokenshaDaichoModel model) {

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

        switch (ViewExecutionStatus.toValue(shikakuHenkoRirekiDiv.getExecutionStatus())) {
            case Add:
                modifyEntryData();
                break;

            case Modify:
                modifyEntryData();
                break;
            case Delete:
                deleteEntryData();
                break;
        }
    }

    private void modifyEntryData() {
        HihokenshaDaichoModel model = new HihokenshaDaichoModel();
        model.set資格変更年月日(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoDate().getValue());
        model.set資格変更届出年月日(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoTodokedeDate().getValue());
        model.set資格変更事由(ShikakuHenkoJiyu.toValue(
                shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().getSelectedKey()));
        model.set被保険者番号(new HihokenshaNo(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo()));
        model.set処理日時(new YMDHMS(toGYYMMDDHHMMSS(RDate.getNowDateTime())));
        model.set旧市町村コード(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoKyuHokensha().getSelectedKey()));
        model.set広住特措置元市町村コード(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoSochimotoHokensha().getSelectedKey()));

        update資格変更履歴(model);
    }
    private static final int BEGININDEX = 0;
    private static final int ENDINDEX = 14;

    private RString toGYYMMDDHHMMSS(RDateTime dateTime) {
        return (dateTime == null || dateTime.toString().isEmpty()) ? RString.EMPTY : new RStringBuilder(dateTime.getDate().toDateString()).
                append(new RString("".concat(dateTime.getTime().toString()))).replace(":", "").replace(".", "").replace(" ", "").substring(BEGININDEX, ENDINDEX);
    }

    public void update資格変更履歴(HihokenshaDaichoModel model) {
        RString rowState = new RString(shikakuHenkoRirekiDiv.getExecutionStatus().toString());
        IItemList<HihokenshaDaichoModel> models = get被保険者台帳情報();
        switch (ViewExecutionStatus.toValue(rowState)) {
            case Add:
                models = models.added(model);
                break;
            case Modify:
                models = update履歴(shikakuHenkoRirekiDiv, ShikakuHenkoMapper.merge(model));
                break;
            case Delete:
                models = update履歴(shikakuHenkoRirekiDiv, ShikakuHenkoMapper.delete());
            default:
                break;
        }
        set被保険者台帳情報(models);
    }

    private IItemList<HihokenshaDaichoModel> update履歴(final ShikakuHenkoRirekiDiv d, IConsumer<HihokenshaDaichoModel> consumer) {
        int rowIndex = Integer.valueOf(d.getSelectRow().toString()).intValue();
        dgHenko_Row 更新行 = shikakuHenkoRirekiDiv.getDgHenko().getDataSource().get(rowIndex);

        IItemList<HihokenshaDaichoModel> models = get被保険者台帳情報();
        models.filter(ShikakuHenkoMapper.createKey(更新行))
                .findJustOne()
                .ifPresent(consumer);
        return models;
    }

    private void deleteEntryData() {
        HihokenshaDaichoModel model = new HihokenshaDaichoModel();
        model.set資格変更年月日(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoDate().getValue());
        model.set資格変更届出年月日(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoTodokedeDate().getValue());
        model.set資格変更事由(ShikakuHenkoJiyu.toValue(
                shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().getSelectedKey()));
        model.set市町村コード(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo()));
        model.set処理日時(new YMDHMS(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiShoriDatetime()));
        model.set旧市町村コード(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoKyuHokensha().getSelectedKey()));
        model.set広住特措置元市町村コード(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoSochimotoHokensha().getSelectedKey()));
        update資格変更履歴(model);
    }

    /**
     * Divに登録されている、変更される被保険者台帳Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> get被保険者台帳情報() {
        IItemList<HihokenshaDaichoModel> editing被保険者台帳List
                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.class);
        return editing被保険者台帳List;
    }

    private List<KeyValueDataSource> createRStringKeyValue(List<RString> dataSource) {
        List<KeyValueDataSource> list = new ArrayList<>();
        int key = 0;
        for (RString rstr : dataSource) {
            list.add(new KeyValueDataSource(new RString(String.valueOf(++key)), rstr));
        }
        return list;
    }

    private void setTanitsuGappeiAri(HihokenshaDaichoList 被保険者List) {

        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setDataSource(createKyuhokenshaDataSource(被保険者List));
    }

    private void setKoikiGappeiNashi(HihokenshaDaichoList 被保険者List) {

        shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().setDataSource(createSochimotoDataSource(被保険者List));
    }

    private void setKoikiGappeiAri(HihokenshaDaichoList 被保険者List) {

        shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().setDataSource(createSochimotoDataSource(被保険者List));
        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setDataSource(createKyuhokenshaDataSource(被保険者List));
    }

    /**
     * グリッド上で選択した資格異動の情報を、明細エリアに表示します。
     */
    public void showSelectedData() {
        dgHenko_Row selRow = shikakuHenkoRirekiDiv.getDgHenko().getClickedItem();
        shikakuHenkoRirekiDiv.setSelectRow(new RString(String.valueOf(selRow.getId())));
        shikakuHenkoRirekiDiv.setSelectIdoYMD(new RString(selRow.getHenkoDate().getValue().toString()));
        shikakuHenkoRirekiDiv.getTxtHenkoDate().setValue(selRow.getHenkoDate().getValue());
        shikakuHenkoRirekiDiv.getTxtHenkoTodokedeDate().setValue(selRow.getHenkoTodokedeDate().getValue());
        shikakuHenkoRirekiDiv.getDdlHenkoJiyu().setSelectedKey(selRow.getHenkoJiyuKey());
        shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().setSelectedKey(selRow.getSochimotoHokensha());
        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setSelectedKey(selRow.getKyuHokensha());
    }

    /**
     * 明細エリアの情報を初期化します。
     */
    public void clearInputData() {

        shikakuHenkoRirekiDiv.getHenkoInput().setHenkojiHihokenshaNo(RString.EMPTY);
        shikakuHenkoRirekiDiv.getHenkoInput().setHenkojiShoriDatetime(RString.EMPTY);
        shikakuHenkoRirekiDiv.getHenkoInput().getDdlJuminJoho().setSelectedValue(RString.EMPTY);
        shikakuHenkoRirekiDiv.getTxtHenkoDate().clearValue();
        shikakuHenkoRirekiDiv.getTxtHenkoTodokedeDate().clearValue();
        shikakuHenkoRirekiDiv.getDdlHenkoJiyu().setSelectedIndex(0);
        shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().setSelectedIndex(0);
        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setSelectedIndex(0);
        shikakuHenkoRirekiDiv.getDdlJuminJoho().setDataSource(new ArrayList<KeyValueDataSource>());
    }

    /**
     * Divに登録されている変更前後の履歴をマージすることで、更新処理などで利用可能な履歴を作成して返します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> get資格関連異動履歴() {
        IItemList<HihokenshaDaichoModel> baseList
                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.class);
        IItemList<HihokenshaDaichoModel> editingList
                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_EDITING_KEY, ItemList.class);

        return merge(baseList, editingList);
    }

    private IItemList<HihokenshaDaichoModel> merge(IItemList<HihokenshaDaichoModel> baseList, IItemList<HihokenshaDaichoModel> editingList) {

        List<HihokenshaDaichoModel> mergedList = new ArrayList<>();

        for (HihokenshaDaichoModel editingModel : editingList) {
            IOptional<HihokenshaDaichoModel> justOne = baseList.findJustOne();

            if (!justOne.isPresent()) {
                mergedList.add(editingModel);
                continue;
            }

            HihokenshaDaichoModel baseModel = justOne.get();
            if (editingModel.getState().equals(baseModel.getState())) {
                mergedList.add(editingModel);
                continue;
            }

            switch (editingModel.getState()) {
                case Modified:
                    HihokenshaDaichoModel addingModel = new HihokenshaDaichoModel(editingModel.getEntity());
                    addingModel.set処理日時(plusOneSeconds(addingModel.get処理日時()));
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

    private YMDHMS plusOneSeconds(YMDHMS 処理日時) {
        RDateTime dateTime処理日時 = 処理日時.getRDateTime().plusSeconds(ONE_SECONDS);
        RString dateStr = dateTime処理日時.getDate().toDateString();

        int hour = dateTime処理日時.getTime().getHour();
        RString hourStr = new RString(Integer.toString(hour)).padZeroToLeft(2);
        int minute = dateTime処理日時.getTime().getMinute();
        RString minuteStr = new RString(Integer.toString(minute)).padZeroToLeft(2);
        int second = dateTime処理日時.getTime().getSecond();
        RString secondStr = new RString(Integer.toString(second)).padZeroToLeft(2);

        return new YMDHMS(dateStr.concat(hourStr).concat(minuteStr).concat(secondStr));
    }

    /**
     * 明細パネルが変更されたかどうかを判定します。 <br/>
     * 追加を行う場合は、明細行の内容が全て空白で無ければtrueを返します。<br/>
     * 修正を行う場合は、明細行の内容が書き換えられている場合にtrueを返します。
     *
     * @return 明細パネルの内容が変更されていたらtrue
     */
    public boolean hasChangedInMeisai() {
        ViewExecutionStatus exeStatus = ViewExecutionStatus.toValue(shikakuHenkoRirekiDiv.getExecutionStatus());

        if (exeStatus == ViewExecutionStatus.Add) {
            return !equalsMeisaiToEmpty();
        }
        return !(equalsMeisaiTo(findHenkoMeisaiOriginModel()));

    }

    private boolean equalsMeisaiToEmpty() {

        if (!shikakuHenkoRirekiDiv.getTxtHenkoDate().getValue().equals(FlexibleDate.EMPTY)) {
            return false;
        }
        if (!shikakuHenkoRirekiDiv.getTxtHenkoTodokedeDate().getValue().equals(FlexibleDate.EMPTY)) {
            return false;
        }
        if (shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedIndex() != 0) {
            return false;
        }
        if (shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedIndex() != 0) {
            return false;
        }
        if (shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedIndex() != 0) {
            return false;
        }

        if (shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedIndex() != 0) {
            return false;
        }
        if (shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedIndex() != 0) {
            return false;
        }

        return shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedIndex() != 0;
    }

    private boolean equalsMeisaiTo(HihokenshaDaichoModel targetModel) {

        if (!targetModel.get資格変更年月日().equals(shikakuHenkoRirekiDiv.getTxtHenkoDate().getValue())) {
            return false;
        }
        if (!targetModel.get資格変更届出年月日().equals(shikakuHenkoRirekiDiv.getTxtHenkoTodokedeDate().getValue())) {
            return false;
        }
        if (!targetModel.get資格変更事由().getCode().equals(shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedKey())) {
            return false;
        }
        if (!targetModel.get広住特措置元市町村コード().value().equals((shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().getSelectedKey()))) {
            return false;
        }
        return !targetModel.get旧市町村コード().equals(new LasdecCode(shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().getSelectedKey()));

    }

    private HihokenshaDaichoModel findHenkoMeisaiOriginModel() {
        LasdecCode 市町村コード = new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo());
        HihokenshaNo 被保険者番号 = new HihokenshaNo(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo());
        YMDHMS 処理日時 = new YMDHMS(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiShoriDatetime());
        IPredicate<HihokenshaDaichoModel> condition = new HihokendhaDaichoKey(市町村コード, 被保険者番号, 処理日時);
        return get被保険者台帳情報().filter(condition).findJustOne().get();
    }

    /**
     * 明細に入力可能になる前に共通的に使用される処理です。<br/>
     * <ul>
     * <li>追加ボタンに非活性を設定</li>
     * <li>住所地特例グリッドに読み込み不可を設定</li>
     * </ul>
     */
    public void setupToBeforeInput() {
        shikakuHenkoRirekiDiv.getBtnAdd().setDisabled(true);
        shikakuHenkoRirekiDiv.getDgHenko().setReadOnly(true);
    }

    /**
     * 明細に入力が完了したときや、取消ボタンの押下等によって入力を取りやめた場合に、共通的に使用される処理です。<br/>
     * <ul>
     * <li>追加ボタンに活性を設定</li>
     * <li>住所地特例グリッドに読み込み可を設定</li>
     * </ul>
     */
    public void setupToAfterInput() {
        shikakuHenkoRirekiDiv.getBtnAdd().setDisabled(false);
        shikakuHenkoRirekiDiv.getDgHenko().setReadOnly(false);
    }

    /**
     * 自身が持つ処理区分に対して、引数から受け取った値を設定します。
     *
     * @param status 処理区分
     */
    public void setExecutionStatus(ViewExecutionStatus status) {
        shikakuHenkoRirekiDiv.setExecutionStatus(status.getValue());
    }

    private List<KeyValueDataSource> createSochimotoDataSource(HihokenshaDaichoList 被保険者List) {

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (HihokenshaDaichoModel hihokensha : 被保険者List) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(hihokensha.get広住特措置元市町村コード().getColumnValue());
            //TODO n8235 船山洋介 広住特措置元市町村コードより名称を取得できるようになったら修正。
            keyValueDataSource.setValue(get構成市町村名称(hihokensha.get広住特措置元市町村コード()));

            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    private RString get構成市町村名称(LasdecCode 構成市町村コード) {
        //TODO n8235 船山洋介 構成市町村コードより名称を取得できるようになったら修正。
        return RString.EMPTY;
    }

    private List<KeyValueDataSource> createKyuhokenshaDataSource(HihokenshaDaichoList 被保険者List) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (HihokenshaDaichoModel hihokensha : 被保険者List) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(hihokensha.get旧市町村コード().getColumnValue());
            //TODO n8235 船山洋介 旧市町村コード取得マネージャーができたら修正する
            //keyValueDataSource.setValue(get旧市町村名称(hihokensha.get旧市町村コード()));
            keyValueDataSource.setValue(get旧市町村名称(hihokensha.get旧市町村コード()));
            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    private RString get旧市町村名称(LasdecCode 旧保険者コード) {
        //TODO n8235 船山洋介 旧市町村コードより名称を取得できるようになったら修正。
        if (!旧保険者コード.isEmpty()) {
            return Kyuhokensha.toValue(旧保険者コード.getColumnValue()).getName();
        }
        return RString.EMPTY;
    }

    private RString get旧市町村コード(RString 市町村名称) {
        //TODO n8235 船山洋介 旧市町村コードより名称を取得できるようになったら修正。
        if (!市町村名称.isEmpty()) {
            return Kyuhokensha.toKey(市町村名称).getCode();
        }
        return RString.EMPTY;
    }

    public HihokenshaDaichoModel get更新前選択被保険者台帳() {
        ItemList<HihokenshaDaichoModel> get = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.class);
        return get.toList().get(Integer.parseInt(shikakuHenkoRirekiDiv.getSelectRow().toString()));
    }

}

/**
 * 南魚の旧保険者一覧の列挙型クラスです。
 * Manager・Finderが実装されたら削除します。
 *
 * @author N8235 船山 洋介
 */
enum Kyuhokensha {

    六日町("000001"),
    大和町("000002"),
    塩沢町("000003");

    private final RString code;
    private final RString oldName;

    private Kyuhokensha(String code) {
        this.code = new RString(code);
        this.oldName = new RString(name());
    }

    public RString getCode() {
        return code;
    }

    public RString getName() {
        return oldName;
    }

    /**
     * RString型の要介護状態区分コードをもらい、コードに対応するYokaigoJotaiKubun09型のenumを返します。
     *
     * @param code 要介護状態区分コード
     * @return 引数のコードに対応するYokaigoJotaiKubun09型のenum
     */
    public static Kyuhokensha toValue(RString code) {
        for (Kyuhokensha data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

    public static Kyuhokensha toKey(RString name) {
        for (Kyuhokensha data : values()) {
            if (data.getName().equals(name)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

}
