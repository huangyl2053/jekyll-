/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.台帳種別の列を;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.施設種類の列を;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.表示Heightサイズ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.表示widthサイズ;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModelComparators;
import jp.co.ndensan.reams.db.dbz.realservice.ShisetsuNyutaishoTokureiTaishoRelateManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 施設履歴情報共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223　朴義一
 */
public class ShisetsuNyutaishoRirekiKanriHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv div;
    protected static final RString PANEL_SESSION_ACCESSOR_KEY = new RString("shisetsuNyutaishoRirekiKanriDiv");

    /**
     * コンストラクタです。
     *
     * @param shisetsuNyutaishoRirekiDiv 施設情報共有子Divのエンティティ
     */
    public ShisetsuNyutaishoRirekiKanriHandler(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {
        this.div = shisetsuNyutaishoRirekiDiv;
    }

    /**
     * i
     * 初期化処理です。
     */
    public void initialize() {

        //TODO n8178 城間篤人 画面上でモードを設定し忘れると、NullPointerExceptionで落ちてしまうため、何かしらの回避処理をはさむほうがよいか？
        switch (div.getMode_利用()) {
            case 台帳種別表示機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示する);
                div.setMode_施設種類の列を(施設種類の列を.表示する);
                div.setMode_表示widthサイズ(表示widthサイズ.モード1);
                div.setMode_表示heightサイズ(表示Heightサイズ.サイズ200);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(0);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(DaichoType.被保険者.getCode());
                break;
            case 被保険者対象機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                div.setMode_施設種類の列を(施設種類の列を.表示する);
                div.setMode_表示widthサイズ(表示widthサイズ.モード3);
                div.setMode_表示heightサイズ(表示Heightサイズ.サイズ200);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(1);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 他市町村住所地特例者対象機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                div.setMode_施設種類の列を(施設種類の列を.表示する);
                div.setMode_表示widthサイズ(表示widthサイズ.モード3);
                div.setMode_表示heightサイズ(表示Heightサイズ.サイズ200);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(2);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 適用除外者対象機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                div.setMode_施設種類の列を(施設種類の列を.表示しない);
                div.setMode_表示widthサイズ(表示widthサイズ.モード5);
                div.setMode_表示heightサイズ(表示Heightサイズ.サイズ200);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(3);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            default:
                break;
        }
    }

    /**
     * 施設入退所をロードする処理です。
     *
     * @param 識別コード 識別コード
     */
    public void load(ShikibetsuCode 識別コード) {

        ShisetsuNyutaishoTokureiTaishoRelateManager manager = new ShisetsuNyutaishoTokureiTaishoRelateManager();

        IItemList<ShisetsuNyutaishoRelateModel> list = manager.get介護保険施設入退所一覧By主キー1(識別コード);

        set施設入退所履歴(list);
    }

    /**
     * 明細の各項目の値をクリア処理です。
     */
    public void clearInputData() {
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().clearValue();
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().clearValue();
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().clear();

        switch (div.getMode_利用()) {
            case 台帳種別表示機能:
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(DaichoType.被保険者.getCode());
                break;
            case 被保険者対象機能:
                break;
            case 他市町村住所地特例者対象機能:
                break;
            case 適用除外者対象機能:
                break;
            default:
                break;
        }
    }

    public void update施設入退所履歴(ShisetsuNyutaishoRelateModel model) {
        RString rowState = div.getInputMode();
        IItemList<ShisetsuNyutaishoRelateModel> models = get施設入退所履歴();
        switch (ViewExecutionStatus.toValue(rowState)) {
            case Add:
                models = models.added(model);
                break;
            case Modify:
                models = update履歴(div, ShisetsuNyutaishoMapper.merge(model));
                break;
            case Delete:
                models = update履歴(div, ShisetsuNyutaishoMapper.delete());
            default:
                break;
        }
        set施設入退所履歴(models);
    }

    private IItemList<ShisetsuNyutaishoRelateModel> update履歴(final ShisetsuNyutaishoRirekiKanriDiv d, IConsumer<ShisetsuNyutaishoRelateModel> consumer) {
        int rowIndex = Integer.valueOf(d.getSelectRow().toString()).intValue();
        dgShisetsuNyutaishoRireki_Row 更新行 = div.getDgShisetsuNyutaishoRireki().getDataSource().get(rowIndex);

        IItemList<ShisetsuNyutaishoRelateModel> models = get施設入退所履歴();
        models.filter(ShisetsuNyutaishoMapper.createKey(更新行))
                .findJustOne()
                .ifPresent(consumer);
        return models;
    }

    /**
     * グリッド上から選択した施設入退所履歴の情報を、明細エリアに表示します。
     *
     * @param clickedItem グリッド上から選択した要素
     */
    public void showSelectedData(dgShisetsuNyutaishoRireki_Row clickedItem) {
        dgShisetsuNyutaishoRireki_Row selRow = clickedItem;
        div.setSelectRow(new RString(String.valueOf(selRow.getId())));

        ShisetsuNyutaishoRelateModel model = new ShisetsuNyutaishoRelateModel();

        model.get介護保険施設入退所モデル().set入所年月日(selRow.getNyushoDate().getValue());
        model.get介護保険施設入退所モデル().set退所年月日(selRow.getTaishoDate().getValue());
        model.get介護保険施設入退所モデル().set台帳種別(new RString(selRow.getDaichoShubetsuKey().toString()));
        model.get介護保険施設入退所モデル().set入所施設種類(new RString(selRow.getShisetsuShuruiKey().toString()));
        model.get介護保険施設入退所モデル().set入所施設コード(new RString(selRow.getShisetsuCode().toString()));
        model.setJigyoshaMeisho(new RString(selRow.getShisetsuMeisho().toString()));

        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setValue(model.get介護保険施設入退所モデル().get入所年月日());
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setValue(model.get介護保険施設入退所モデル().get退所年月日());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(model.get介護保険施設入退所モデル().get台帳種別());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設種類(model.get介護保険施設入退所モデル().get入所施設種類());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set入所施設コード(model.get介護保険施設入退所モデル().get入所施設コード());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設名称(model.getJigyoshaMeisho());
    }

    /**
     * Divに登録されている施設入退所履歴Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<ShisetsuNyutaishoRelateModel> get施設入退所履歴() {
        IItemList<ShisetsuNyutaishoRelateModel> 施設入退所履歴List
                = PanelSessionAccessor.get(div, PANEL_SESSION_ACCESSOR_KEY, ItemList.class);
        return 施設入退所履歴List;
    }

    /**
     * 引数から受け取った施設入退所履歴Listの情報をDivに登録し、グリッド上にマッピングします。
     *
     * @param 施設入退所履歴List 施設入退所履歴List
     */
    public void set施設入退所履歴(IItemList<ShisetsuNyutaishoRelateModel> 施設入退所履歴List) {
        PanelSessionAccessor.put(div, PANEL_SESSION_ACCESSOR_KEY, ItemList.newItemList(施設入退所履歴List));

        施設入退所履歴List = 施設入退所履歴List.sorted(ShisetsuNyutaishoModelComparators.orderBy入所年月日.desc());
        div.getDgShisetsuNyutaishoRireki().setDataSource(施設入退所履歴List.map(ShisetsuNyutaishoMapper.toGridRow()).toList());
    }

    /**
     * 施設入退所管理が内部で持つ、施設入退所に変更が存在するか否かを判定します。
     *
     * @return 施設入退所情報に変更が存在するならtrue
     */
    public boolean hasChanged() {
        IItemList<ShisetsuNyutaishoRelateModel> nyutaishoList = get施設入退所履歴();
        for (ShisetsuNyutaishoRelateModel nyutaisho : nyutaishoList) {
            if (nyutaisho.getState() == EntityDataState.Unchanged) {
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * 明細パネルに変更があるか否かを判定します。
     *
     * @return 明細パネルに変更が存在する場合true
     */
    public boolean hasChangedInMeisai() {
        boolean flg = Boolean.FALSE;
        switch (ViewExecutionStatus.toValue(div.getInputMode())) {
            case Add:

                if (!div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue().isEmpty()) {
                    flg = Boolean.TRUE;
                } else if (!div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue().isEmpty()) {
                    flg = Boolean.TRUE;
                } else if (div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().toString().isEmpty()) {
                    flg = Boolean.TRUE;
                }
                break;

            case Modify:
                int rowIndex = Integer.valueOf(div.getSelectRow().toString()).intValue();
                dgShisetsuNyutaishoRireki_Row 選択行 = div.getDgShisetsuNyutaishoRireki().getDataSource().get(rowIndex);

                RString 入所年月日 = composeNulltoStr(new RString(div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue().toString()));
                RString 退所年月日 = composeNulltoStr(new RString(div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue().toString()));
                RString 台帳種別 = composeNulltoStr(new RString(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().toString()));
                RString 入所施設種類 = composeNulltoStr(new RString(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類().getCode().toString()));
                RString 入所施設コード = composeNulltoStr(new RString(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get入所施設コード().toString()));
                RString 施設名称 = composeNulltoStr(new RString(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称().toString()));

                if (!入所年月日.equals(composeNulltoStr(new RString(選択行.getNyushoDate().getValue().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!退所年月日.equals(composeNulltoStr(new RString(選択行.getTaishoDate().getValue().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!台帳種別.equals(composeNulltoStr(new RString(選択行.getDaichoShubetsuKey().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!入所施設種類.equals(composeNulltoStr(new RString(選択行.getShisetsuShuruiKey().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!入所施設コード.equals(composeNulltoStr(new RString(選択行.getShisetsuCode().toString())))) {
                    flg = Boolean.TRUE;
                } else if (!施設名称.equals(composeNulltoStr(new RString(選択行.getShisetsuMeisho().toString())))) {
                    flg = Boolean.TRUE;
                }

                break;

            case Delete:

                break;
            default:
                break;
        }
        return flg;
    }

    private static RString composeNulltoStr(RString str) {
        RString afterStr;
        if (str == null) {
            afterStr = RString.EMPTY;
        } else {
            afterStr = str;
        }
        return afterStr;
    }
}
