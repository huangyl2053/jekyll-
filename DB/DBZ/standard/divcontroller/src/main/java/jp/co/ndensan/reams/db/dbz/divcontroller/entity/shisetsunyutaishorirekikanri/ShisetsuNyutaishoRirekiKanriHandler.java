/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.台帳種別の列を;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.施設種類の列を;

/**
 * 施設履歴情報共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223　朴義一
 */
public class ShisetsuNyutaishoRirekiKanriHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv div;
    protected static final RString PANEL_SESSION_ACCESSOR_KEY = new RString("shisetsuNyutaishoRirekiKanriDiv");

    private static final RString MODE_INSERT = new RString("追加");
    private static final RString MODE_UPDATE = new RString("修正");
    private static final RString MODE_DELETE = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param shisetsuNyutaishoRirekiDiv 施設情報共有子Divのエンティティ
     */
    public ShisetsuNyutaishoRirekiKanriHandler(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {
        this.div = shisetsuNyutaishoRirekiDiv;
    }

    /**
     * 初期化処理です。
     */
    public void initialize() {
        switch (div.getMode_利用()) {
            case 台帳種別表示機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示する);
                div.setMode_施設種類の列を(施設種類の列を.表示する);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(0);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 被保険者対象機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                div.setMode_施設種類の列を(施設種類の列を.表示する);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(1);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 他市町村住所地特例者対象機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                div.setMode_施設種類の列を(施設種類の列を.表示する);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(2);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 適用除外者対象機能:
                div.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                div.setMode_施設種類の列を(施設種類の列を.表示しない);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(3);
                div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            default:
                break;
        }
    }

    /**
     * 明細の各項目の値をクリア処理です。
     */
    public void clearInputData() {

        div.getShisetsuNyutaishoInput().getTxtNyushoDate().clearValue();
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().clearValue();
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().clear();
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
     * グリリッドに追加する行データを作ります。
     */
    private dgShisetsuNyutaishoRireki_Row create追加行(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        dgShisetsuNyutaishoRireki_Row 追加行 = new dgShisetsuNyutaishoRireki_Row();

        追加行.getNyushoDate().setValue(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue());
        追加行.getTaishoDate().setValue(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue());

        //非表示 入所施設 介護保険施設入退所.入所施設コード 介護保険施設入退所.入所施設名称
        追加行.setShisetsuCode(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get入所施設コード().value());
        追加行.setShisetsuMeisho(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称());
        //表示 入所施設名 介護保険施設入退所.入所施設コード : 介護保険施設入退所.入所施設名称
        追加行.setShisetsu(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get入所施設コード().value().concat(":").concat(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称()));
        //非表示 台帳種別key
        追加行.setDaichoShubetsuKey(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().get().getCode());
        //表示 台帳種別名
        追加行.setDaichoShubetsu((shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().get().getName()));
        //非表示 施設種類key
        追加行.setShisetsuShuruiKey(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類().getCode());
        //表示 施設種類名
        追加行.setShisetsuShurui(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称());

        return 追加行;

    }

    /**
     * グリッドの更新対象行にデータを設定します。
     */
    private void set更新行(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv, dgShisetsuNyutaishoRireki_Row 更新行) {

        更新行.getNyushoDate().setValue(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue());
        更新行.getTaishoDate().setValue(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue());
        //非表示 入所施設 介護保険施設入退所.入所施設コード 介護保険施設入退所.入所施設名称
        更新行.setShisetsuCode(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get入所施設コード().value());
        更新行.setShisetsuMeisho(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称());
        //表示 入所施設名 介護保険施設入退所.入所施設コード : 介護保険施設入退所.入所施設名称
        更新行.setShisetsu(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get入所施設コード().value().concat(":").concat(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称()));
        //非表示 台帳種別key
        更新行.setDaichoShubetsuKey(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().get().getCode());
        //表示 台帳種別名
        更新行.setDaichoShubetsu((shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().get().getName()));
        //非表示 施設種類key
        更新行.setShisetsuShuruiKey(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類().getCode());
        //表示 施設種類名
        更新行.setShisetsuShurui(shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称());

    }

    /**
     * グリッド上から選択した施設入退所履歴の情報を、明細エリアに表示します。
     */
    public void showSelectedData() {
        dgShisetsuNyutaishoRireki_Row selRow = div.getDgShisetsuNyutaishoRireki().getClickedItem();
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
        PanelSessionAccessor.put(div, PANEL_SESSION_ACCESSOR_KEY, ItemList.of(施設入退所履歴List));
        div.getDgShisetsuNyutaishoRireki().setDataSource(施設入退所履歴List.map(ShisetsuNyutaishoMapper.toGridRow()).toList());
    }

    private RString getModelStateValue(ShisetsuNyutaishoRelateModel model) {
        switch (model.getState()) {
            case Added:
                return new RString("追加");
            case Modified:
                return new RString("修正");
            case Deleted:
                return new RString("削除");
            default:
                return new RString("");
        }
    }

}
