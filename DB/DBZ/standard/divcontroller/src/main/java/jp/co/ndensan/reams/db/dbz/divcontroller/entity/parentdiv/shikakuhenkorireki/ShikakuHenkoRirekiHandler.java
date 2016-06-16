/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shikakuhenkorireki;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewExecutionStatus;
//import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
//import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
//import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.session.PanelSessionAccessor;
//import jp.co.ndensan.reams.uz.uza.util.code.ICodeValueObject;

/**
 * 資格変更履歴共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoRirekiHandler {

    private final ShikakuHenkoRirekiDiv shikakuHenkoRirekiDiv;
    private static final RString SESSION_ACCESSOR_KEY = new RString("shikakuHenkouRireki");
    private static final RString SESSION_ACCESSOR_EDITING_KEY = new RString("shikakuHenkouRireki_Editing");
//    private static final RString SESSION_KYU_HOKENSHA = new RString("kyuHokensha");
//    private static final int ONE_SECONDS = 1;

    /**
     * コンストラクタです。
     *
     * @param shikakuHenkoRirekiDiv 住所地特例履歴ListDiv
     */
    public ShikakuHenkoRirekiHandler(ShikakuHenkoRirekiDiv shikakuHenkoRirekiDiv) {
        this.shikakuHenkoRirekiDiv = shikakuHenkoRirekiDiv;
    }

    public void load(LasdecCode 市町村コード, HihokenshaNo HihokenshaNo) {
//        HihokenshaDaichoFinder hihokenshaFinder = new HihokenshaDaichoFinder();
//        IItemList<DbT1001HihokenshaDaichoEntity> find被保険者台帳List = hihokenshaFinder.find被保険者台帳List(市町村コード, HihokenshaNo);
//        set被保険者台帳情報(find被保険者台帳List);
        mapping資格変更履歴();
        setJuminJohoDataSource();
        setHenkoJiyuDataSource();
    }

    public void initialize(LasdecCode 市町村コード, LasdecCode KyuShichosonCode, ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode mode) {
//        HihokenshaDaichoFinder hihokenshaFinder = new HihokenshaDaichoFinder();
//        List<HihokenshaDaicho> list = new ArrayList<>();
//        for (DbT1001HihokenshaDaichoEntity entity : hihokenshaFinder.find直近被保険者台帳一覧(市町村コード)) {
//            list.add(new HihokenshaDaicho(entity));
//        }
//        HihokenshaDaichoList 被保険者List = new HihokenshaDaichoList(ItemList.of(list));

        //       shikakuHenkoRirekiDiv.setMode_HokenshaJohoDisplayMode(mode);
//        switch (shikakuHenkoRirekiDiv.getMode_HokenshaJohoDisplayMode()) {
//            case TanitsuGappeiNashi:
//                break;
//            case TanitsuGappeiAri:
//                setKyuHokensya(KyuShichosonCode);
//                setTanitsuGappeiAri(被保険者List);
//                break;
//            case KoikiGappeiNashi:
//                setJuminJohoDataSource();
//                setKoikiGappeiNashi(被保険者List);
//                break;
//            case KoikiGappeiAri:
//                setKyuHokensya(KyuShichosonCode);
//                setJuminJohoDataSource();
//                setKoikiGappeiAri(被保険者List);
//                break;
//            default:
//                break;
//    }
        setHenkoJiyuDataSource();
    }

//    private void setKyuHokensya(LasdecCode lasdecCode) {

//        KijunTsukiShichosonFinder finder = new KijunTsukiShichosonFinder();
//        Optional<GappeiShichoson> gappeiInfo = finder.get基準月市町村情報(FlexibleDate.getNowDate().getYearMonth(), lasdecCode);
//        if (gappeiInfo.isPresent()) {
        //PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.newItemList(gappeiInfo.get().get単一市町村情報()));
//            PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_KYU_HOKENSHA, null);
//        } else {
//            PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.empty());
//        }
//    }

//    private RString getKyuHokenshaName(final LasdecCode lasdecCode) {
    private RString getKyuHokenshaName() {

        switch (shikakuHenkoRirekiDiv.getMode_HokenshaJohoDisplayMode()) {
            case KoikiGappeiNashi:
            case TanitsuGappeiNashi:
                return RString.EMPTY;
        }

        //TODO n3331 Modelパッケージ廃止に伴うエラー解消のためコメントアウト
        return RString.EMPTY;

//        IItemList<IGappeiShichoson> kyuHokenshaList
//                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_KYU_HOKENSHA, ItemList.class);
//        IPredicate<IGappeiShichoson> predicate = new IPredicate<IGappeiShichoson>() {
//            @Override
//            public boolean evaluate(IGappeiShichoson t) {
//                return t.get旧市町村コード().equals(lasdecCode);
//            }
//        };
//        IItemList<IGappeiShichoson> kyuHokensha = kyuHokenshaList.filter(predicate);
//        if (kyuHokensha.isJustOne() && kyuHokensha.findFirst().isPresent()) {
//            return kyuHokensha.findJustOne().get().get旧市町村名称();
//        } else {
//            return RString.EMPTY;
//        }
    }

    /**
     * 引数から受け取った被保険者台帳Listの情報をDivに登録します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    public void set被保険者台帳情報(IItemList<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.newItemList(被保険者台帳List));
        PanelSessionAccessor.put(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_EDITING_KEY, ItemList.newItemList(被保険者台帳List));
        // TODO n8300姜　ビルドエラー回避のために暫定対応
//        被保険者台帳List = 被保険者台帳List.sorted(DbT1001HihokenshaDaichoEntityComparators.orderByShikakuHenkoYMD.desc());
        shikakuHenkoRirekiDiv.getDgHenko().setDataSource(被保険者台帳List.map(ShikakuHenkoMapper.toGridRow()).toList());
    }

//    private <T extends ICodeValueObject> List<KeyValueDataSource> createCodeMasterKeyValue(List<T> dataSource) {
//        List<KeyValueDataSource> keyValueDataSourceList = new ArrayList<>();
//        for (T data : dataSource) {
//            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(data.toRString(), data.getMeisho());
//            keyValueDataSourceList.add(keyValueDataSource);
//        }
//        return keyValueDataSourceList;
//    }

    private void setHenkoJiyuDataSource() {
        //TODO n8235　船山洋介 DBXCodeShubetsuがICodeShubetsuに適応できないため、コメントアウト。　使用できるようになったら修正。
        // List<KaigoShikakuHenkoJiyu> henkoJiyuList = CodeMasterHelper.getCode(DBXCodeShubetsu.介護資格変更事由);
//        shikakuHenkoRirekiDiv.getDdlHenkoJiyu().setDataSource(createCodeMasterKeyValue(henkoJiyuList));
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
        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();
        IItemList<HihokenshaDaicho> 資格異動List = new HihokenshaDaichoList(get被保険者台帳情報()).to資格関連異動List();
        for (HihokenshaDaicho entity : 資格異動List) {
            list.add(entity.toEntity());
        }
        List<dgHenko_Row> dataSource = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : list) {
            dataSource.add(createRow(entity));
        }
        shikakuHenkoRirekiDiv.getDgHenko().setDataSource(dataSource);
    }

    private dgHenko_Row createRow(DbT1001HihokenshaDaichoEntity model) {
        dgHenko_Row row = new dgHenko_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate());
        TextBoxFlexibleDate shoriDate = new TextBoxFlexibleDate();
        shoriDate.setValue(model.getIdoYMD());
        setRowState(row, model);
        row.setShoriDate(shoriDate);
        row.setHenkoJiyuKey(model.getShikakuHenkoJiyuCode());
        row.setHenkoJiyu(model.getShikakuHenkoJiyuCode());
        row.getHenkoDate().setValue(model.getShikakuHenkoYMD());
        row.getHenkoTodokedeDate().setValue(model.getShikakuHenkoTodokedeYMD());
        LasdecCode sochimotoShichosonCode = model.getKoikinaiTokureiSochimotoShichosonCode();
        if (sochimotoShichosonCode != null) {
            row.setSochimotoHokensha(sochimotoShichosonCode.getColumnValue());
        }
//        row.setKyuHokensha(getKyuHokenshaName(model.getKyuShichosonCode()));
        row.setKyuHokensha(getKyuHokenshaName());
        if (model.getLastUpdateTimestamp() != null) {
            row.getShoriDate().setValue(new FlexibleDate(model.getLastUpdateTimestamp().getDate().toDateString()));
        } else {
            row.getShoriDate().setValue(FlexibleDate.getNowDate());
        }
        return row;
    }

    private void setRowState(dgHenko_Row row, DbT1001HihokenshaDaichoEntity model) {

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
                addEntryData();
                break;

            case Modify:
                modifyEntryData();
                break;
            case Delete:
                deleteEntryData();
                break;
            default:
        }
    }

    private void addEntryData() {
        DbT1001HihokenshaDaichoEntity model = createEntryData();
        model.setIdoYMD(new FlexibleDate(RDate.getNowDateTime().toString()));

        update資格変更履歴(model);
    }

    private void modifyEntryData() {
        DbT1001HihokenshaDaichoEntity model = createEntryData();
        model.setIdoYMD(new FlexibleDate(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiShoriDatetime()));

        update資格変更履歴(model);
    }

    private DbT1001HihokenshaDaichoEntity createEntryData() {
        DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();
        model.setShikakuHenkoYMD(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoDate().getValue());
        model.setShikakuHenkoTodokedeYMD(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoTodokedeDate().getValue());
        model.setShikakuHenkoJiyuCode(
                shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().getSelectedKey());
        model.setHihokenshaNo(new HihokenshaNo(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo()));
        model.setKyuShichosonCode(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoKyuHokensha().getSelectedKey()));
        model.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoSochimotoHokensha().getSelectedKey()));
        return model;
    }

//    private static final int BEGININDEX = 0;
//    private static final int ENDINDEX = 14;

//    private RString toGYYMMDDHHMMSS(RDateTime dateTime) {
//        return (dateTime == null || dateTime.toString().isEmpty()) ? RString.EMPTY : new RStringBuilder(dateTime.getDate().toDateString()).
//                append(new RString("".concat(dateTime.getTime().toString()))).replace(":", "").replace(".", "").replace(" ", "").substring(BEGININDEX, ENDINDEX);
//    }

    public void update資格変更履歴(DbT1001HihokenshaDaichoEntity model) {
        RString rowState = new RString(shikakuHenkoRirekiDiv.getExecutionStatus().toString());
        IItemList<DbT1001HihokenshaDaichoEntity> list = get資格関連異動履歴();
        for (HihokenshaDaicho entity : get被保険者台帳情報()) {
            list.added(entity.toEntity());
        }
        switch (ViewExecutionStatus.toValue(rowState)) {
            case Add:
                list = list.added(model);
                break;
            case Modify:
//                list = update履歴(shikakuHenkoRirekiDiv, ShikakuHenkoMapper.merge(model));
                list = update履歴();
                break;
            case Delete:
//                list = update履歴(shikakuHenkoRirekiDiv, ShikakuHenkoMapper.delete());
                list = update履歴();
                break;
            default:
                break;
        }
        set被保険者台帳情報(list);
    }

//    private IItemList<DbT1001HihokenshaDaichoEntity> update履歴(final ShikakuHenkoRirekiDiv d, IConsumer<DbT1001HihokenshaDaichoEntity> consumer) {
    private IItemList<DbT1001HihokenshaDaichoEntity> update履歴() {
//        int rowIndex = Integer.valueOf(d.getSelectRow().toString()).intValue();
//        dgHenko_Row 更新行 = shikakuHenkoRirekiDiv.getDgHenko().getDataSource().get(rowIndex);

        // TODO n8300姜　ビルドエラー回避のために暫定対応
//        IItemList<HihokenshaDaicho> models = get被保険者台帳情報();
//        models.filter(ShikakuHenkoMapper.createKey(更新行))
//                .findJustOne()
//                .ifPresent(consumer);
//        return models;
        return null;
    }

    private void deleteEntryData() {
        DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();
        model.setShikakuHenkoYMD(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoDate().getValue());
        model.setShikakuHenkoTodokedeYMD(shikakuHenkoRirekiDiv.getHenkoInput().getTxtHenkoTodokedeDate().getValue());
        model.setShikakuHenkoJiyuCode(
                shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoJiyu().getSelectedKey());
        model.setShichosonCode(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo()));

        model.setIdoYMD(new FlexibleDate(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiShoriDatetime()));
        model.setKyuShichosonCode(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoKyuHokensha().getSelectedKey()));
        model.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getDdlHenkoSochimotoHokensha().getSelectedKey()));
        update資格変更履歴(model);
    }

    /**
     * Divに登録されている、変更される被保険者台帳Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaicho> get被保険者台帳情報() {
        IItemList<HihokenshaDaicho> editing被保険者台帳List
                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.class
                );
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

//    private void setTanitsuGappeiAri(HihokenshaDaichoList 被保険者List) {
//
//        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setDataSource(createKyuhokenshaDataSource(被保険者List));
//    }

//    private void setKoikiGappeiNashi(HihokenshaDaichoList 被保険者List) {
//
//        shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().setDataSource(createSochimotoDataSource(被保険者List));
//    }

//    private void setKoikiGappeiAri(HihokenshaDaichoList 被保険者List) {
//
//        shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().setDataSource(createSochimotoDataSource(被保険者List));
//        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setDataSource(createKyuhokenshaDataSource(被保険者List));
//    }

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
        shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().setSelectedValue(selRow.getKyuHokensha());
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
    public IItemList<DbT1001HihokenshaDaichoEntity> get資格関連異動履歴() {
        IItemList<DbT1001HihokenshaDaichoEntity> baseList
                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.class
                );
        IItemList<DbT1001HihokenshaDaichoEntity> editingList
                = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_EDITING_KEY, ItemList.class);

        return merge(baseList, editingList);
    }

    private IItemList<DbT1001HihokenshaDaichoEntity> merge(IItemList<DbT1001HihokenshaDaichoEntity> baseList, IItemList<DbT1001HihokenshaDaichoEntity> editingList) {

        List<DbT1001HihokenshaDaichoEntity> mergedList = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity editingModel : editingList) {
            Optional<DbT1001HihokenshaDaichoEntity> justOne = baseList.findJustOne();

            if (!justOne.isPresent()) {
                mergedList.add(editingModel);
                continue;
            }

            DbT1001HihokenshaDaichoEntity baseModel = justOne.get();
            if (editingModel.getState().equals(baseModel.getState())) {
                mergedList.add(editingModel);
                continue;
            }

            switch (editingModel.getState()) {
                case Modified:
                    DbT1001HihokenshaDaichoEntity addingModel = editingModel;
                    addingModel.setIdoYMD((addingModel.getIdoYMD().plusDay(1)));
                    mergedList.add(addingModel);
                    break;
                case Deleted:
                    baseModel.setIsDeleted(true);
                    mergedList.add(baseModel);
                    break;
                default:
                    break;
            }

        }
        return ItemList.of(mergedList);
    }

//    private YMDHMS plusOneSeconds(YMDHMS 処理日時) {
//        RDateTime dateTime処理日時 = 処理日時.getRDateTime().plusSeconds(ONE_SECONDS);
//        RString dateStr = dateTime処理日時.getDate().toDateString();
//
//        int hour = dateTime処理日時.getTime().getHour();
//        RString hourStr = new RString(Integer.toString(hour)).padZeroToLeft(2);
//        int minute = dateTime処理日時.getTime().getMinute();
//        RString minuteStr = new RString(Integer.toString(minute)).padZeroToLeft(2);
//        int second = dateTime処理日時.getTime().getSecond();
//        RString secondStr = new RString(Integer.toString(second)).padZeroToLeft(2);
//
//        return new YMDHMS(dateStr.concat(hourStr).concat(minuteStr).concat(secondStr));
//    }

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

    private boolean equalsMeisaiTo(DbT1001HihokenshaDaichoEntity targetModel) {

        if (!Objects.equal(targetModel.getShikakuHenkoYMD(), (shikakuHenkoRirekiDiv.getTxtHenkoDate().getValue()))) {
            return false;
        }
        if (!Objects.equal(targetModel.getShikakuHenkoTodokedeYMD(), (shikakuHenkoRirekiDiv.getTxtHenkoTodokedeDate().getValue()))) {
            return false;
        }
        if (!Objects.equal(targetModel.getShikakuHenkoJiyuCode(), (shikakuHenkoRirekiDiv.getDdlHenkoJiyu().getSelectedKey()))) {
            return false;
        }
        LasdecCode sochimotoShichosonCode = targetModel.getKoikinaiTokureiSochimotoShichosonCode();
        if (sochimotoShichosonCode != null) {
            if (!sochimotoShichosonCode.value().equals((shikakuHenkoRirekiDiv.getDdlHenkoSochimotoHokensha().getSelectedKey()))) {
                return false;
            }
        }

        return !Objects.equal(targetModel.getKyuShichosonCode(), (new LasdecCode(shikakuHenkoRirekiDiv.getDdlHenkoKyuHokensha().getSelectedKey())));

    }

    private DbT1001HihokenshaDaichoEntity findHenkoMeisaiOriginModel() {
//        LasdecCode 市町村コード = new LasdecCode(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo());
//        HihokenshaNo 被保険者番号 = new HihokenshaNo(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiHihokenshaNo());

//        ShoriTimestamp 処理日時 = ShoriTimestamp.of(new YMDHMS(shikakuHenkoRirekiDiv.getHenkoInput().getHenkojiShoriDatetime()));
        // TODO n8300姜　ビルドエラー回避のために暫定対応
//        IPredicate<HihokenshaDaichoModel> condition = new HihokendhaDaichoKey(市町村コード, 被保険者番号, 処理日時);
//        return get被保険者台帳情報().filter(condition).findJustOne().get();
        return null;
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

    //TODO n8178 被保険者ではなく、旧保険者情報を参照するように修正する必要がある。 2015年2月末
//    private List<KeyValueDataSource> createSochimotoDataSource(HihokenshaDaichoList 被保険者List) {
//
//        List<KeyValueDataSource> dataSource = new ArrayList<>();
//        for (HihokenshaDaicho hihokensha : 被保険者List) {
//            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
//            keyValueDataSource.setKey(hihokensha.get広住特措置元市町村コード().getColumnValue());
//            //TODO n8235 船山洋介 広住特措置元市町村コードより名称を取得できるようになったら修正。
//            keyValueDataSource.setValue(get構成市町村名称(hihokensha.get広住特措置元市町村コード()));
//
//            dataSource.add(keyValueDataSource);
//        }
//        return dataSource;
//    }

//    private RString get構成市町村名称(LasdecCode 構成市町村コード) {
//        //TODO n8235 船山洋介 構成市町村コードより名称を取得できるようになったら修正。
//        return RString.EMPTY;
//    }

    //TODO n8178 被保険者ではなく、旧保険者情報を参照するように修正する必要がある。 2015年2月末
//    private List<KeyValueDataSource> createKyuhokenshaDataSource(HihokenshaDaichoList 被保険者List) {
//        List<KeyValueDataSource> dataSource = new ArrayList<>();
//        for (HihokenshaDaicho hihokensha : 被保険者List) {
//            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
//            keyValueDataSource.setKey(hihokensha.get旧市町村コード().getColumnValue());
//            //TODO n8235 船山洋介 KyuShichosonCode取得マネージャーができたら修正する
//            //keyValueDataSource.setValue(get旧市町村名称(hihokensha.getKyuShichosonCode()));
//            keyValueDataSource.setValue(get旧市町村名称(hihokensha.get旧市町村コード()));
//            dataSource.add(keyValueDataSource);
//        }
//        return dataSource;
//    }

//    private RString get旧市町村名称(LasdecCode 旧保険者コード) {
//        //TODO n8235 船山洋介 KyuShichosonCodeより名称を取得できるようになったら修正。
//        if (!旧保険者コード.isEmpty()) {
////            return getKyuHokenshaName(旧保険者コード);
//            return getKyuHokenshaName();
//        }
//        return RString.EMPTY;
//    }

    public DbT1001HihokenshaDaichoEntity
            get更新前選択被保険者台帳() {
        ItemList<DbT1001HihokenshaDaichoEntity> get = PanelSessionAccessor.get(shikakuHenkoRirekiDiv, SESSION_ACCESSOR_KEY, ItemList.class
        );
        return get.toList()
                .get(Integer.parseInt(shikakuHenkoRirekiDiv.getSelectRow().toString()));
    }

}
