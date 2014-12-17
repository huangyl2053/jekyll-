/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.利用;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.台帳種別の列を;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.施設種類の列を;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.明細表示モード;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.表示heightサイズ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.表示widthサイズ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv.表示モード;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 施設履歴情報共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223　朴義一
 */
public class ShisetsuNyutaishoRirekiKanriHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv;
    private static final RString PANEL_SESSION_ACCESSOR_KEY = new RString("shisetsuNyutaishoRirekiKanriDiv");

    private static final RString MODE_INSERT = new RString("追加");
    private static final RString MODE_UPDATE = new RString("修正");
    private static final RString MODE_DELETE = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param shisetsuNyutaishoRirekiDiv 施設情報共有子Divのエンティティ
     */
    public ShisetsuNyutaishoRirekiKanriHandler(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {
        this.shisetsuNyutaishoRirekiDiv = shisetsuNyutaishoRirekiDiv;
    }

    /**
     * 初期化処理です。
     */
    public void initialize() {
        switch (shisetsuNyutaishoRirekiDiv.getMode_利用()) {
            case 台帳種別表示機能:
                shisetsuNyutaishoRirekiDiv.setMode_台帳種別の列を(台帳種別の列を.表示する);
                shisetsuNyutaishoRirekiDiv.setMode_施設種類の列を(施設種類の列を.表示する);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(0);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 被保険者対象機能:
                shisetsuNyutaishoRirekiDiv.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                shisetsuNyutaishoRirekiDiv.setMode_施設種類の列を(施設種類の列を.表示する);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(1);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 他市町村住所地特例者対象機能:
                shisetsuNyutaishoRirekiDiv.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                shisetsuNyutaishoRirekiDiv.setMode_施設種類の列を(施設種類の列を.表示する);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(2);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            case 適用除外者対象機能:
                shisetsuNyutaishoRirekiDiv.setMode_台帳種別の列を(台帳種別の列を.表示しない);
                shisetsuNyutaishoRirekiDiv.setMode_施設種類の列を(施設種類の列を.表示しない);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set利用機能(3);
                shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
                break;
            default:
                break;
        }
    }

    /**
     * 明細の各項目の値をクリア処理です。
     */
    public void clearInputData() {

        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtNyushoDate().clearValue();
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtTaishoDate().clearValue();
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().clear();
    }

    /**
     * 明細に入力した内容を一覧に反映します。
     */
    public void reflectDetailedData() {
        int rowIndex = Integer.valueOf(shisetsuNyutaishoRirekiDiv.getSelectRow().toString()).intValue();
        RString rowState = shisetsuNyutaishoRirekiDiv.getInputMode();

        if (MODE_INSERT.equals(rowState)) {
            dgShisetsuNyutaishoRireki_Row 追加行 = create追加行(shisetsuNyutaishoRirekiDiv);
            追加行.setState(MODE_INSERT);
            追加行.setRowState(RowState.Added);
            shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().add(追加行);

        } else if (MODE_UPDATE.equals(rowState)) {
            dgShisetsuNyutaishoRireki_Row 更新行 = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().get(rowIndex);
            if (更新行.getRowState() != RowState.Added) {
                更新行.setState(MODE_UPDATE);
                更新行.setRowState(RowState.Modified);
            } else {
                更新行.setState(MODE_UPDATE);
                更新行.setRowState(RowState.Added);
            }
            set更新行(shisetsuNyutaishoRirekiDiv, 更新行);

        } else if (MODE_DELETE.equals(rowState)) {
            dgShisetsuNyutaishoRireki_Row 削除行 = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().get(rowIndex);
            if (削除行.getRowState() != RowState.Added) {
                削除行.setState(MODE_DELETE);
                削除行.setRowState(RowState.Deleted);
                //shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().remove(削除行);
            } else {
                削除行.setState(MODE_DELETE);
                削除行.setRowState(RowState.Deleted);
            }
        } else {
        }

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
        dgShisetsuNyutaishoRireki_Row selRow = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem();
        shisetsuNyutaishoRirekiDiv.setSelectRow(new RString(String.valueOf(selRow.getId())));

        ShisetsuNyutaishoRelateModel model = new ShisetsuNyutaishoRelateModel();

        model.get介護保険施設入退所モデル().set入所年月日(selRow.getNyushoDate().getValue());
        model.get介護保険施設入退所モデル().set退所年月日(selRow.getTaishoDate().getValue());
        model.get介護保険施設入退所モデル().set台帳種別(new RString(selRow.getDaichoShubetsuKey().toString()));
        model.get介護保険施設入退所モデル().set入所施設種類(new RString(selRow.getShisetsuShuruiKey().toString()));
        model.get介護保険施設入退所モデル().set入所施設コード(new RString(selRow.getShisetsuCode().toString()));
        model.setJigyoshaMeisho(new RString(selRow.getShisetsuMeisho().toString()));

        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtNyushoDate().setValue(model.get介護保険施設入退所モデル().get入所年月日());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtTaishoDate().setValue(model.get介護保険施設入退所モデル().get退所年月日());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(model.get介護保険施設入退所モデル().get台帳種別());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設種類(model.get介護保険施設入退所モデル().get入所施設種類());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set入所施設コード(model.get介護保険施設入退所モデル().get入所施設コード());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設名称(model.getJigyoshaMeisho());
    }

    /**
     * Divに登録されている施設入退所履歴Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<ShisetsuNyutaishoRelateModel> get施設入退所履歴() {
        IItemList<ShisetsuNyutaishoRelateModel> 施設入退所履歴List
                = ItemList.of(PanelSessionAccessor.get(shisetsuNyutaishoRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, ArrayList.class));
        return 施設入退所履歴List;
    }

    /**
     * 引数から受け取った施設入退所履歴Listの情報をDivに登録し、グリッド上にマッピングします。
     *
     * @param 施設入退所履歴List 施設入退所履歴List
     */
    public void set施設入退所履歴(IItemList<ShisetsuNyutaishoRelateModel> 施設入退所履歴List) {
        PanelSessionAccessor.put(shisetsuNyutaishoRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, (ArrayList) 施設入退所履歴List.asList());

        List<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList();

        for (ShisetsuNyutaishoRelateModel model : 施設入退所履歴List) {

            dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row();

            row.setState(getModelStateValue(model));
            //入所日
            row.getNyushoDate().setValue(model.get介護保険施設入退所モデル().get入所年月日());
            //退所日
            row.getTaishoDate().setValue(model.get介護保険施設入退所モデル().get退所年月日());
            //非表示 入所施設 介護保険施設入退所.入所施設コード 介護保険施設入退所.入所施設名称
            row.setShisetsuCode(model.get介護保険施設入退所モデル().get入所施設コード());
            row.setShisetsuMeisho(model.getJigyoshaMeisho());
            //表示 入所施設 介護保険施設入退所.入所施設コード 介護保険施設入退所.入所施設名称
            row.setShisetsu(model.get介護保険施設入退所モデル().get入所施設コード().concat(":").concat(model.getJigyoshaMeisho()));
            //非表示 台帳種別key
            row.setDaichoShubetsuKey(model.get介護保険施設入退所モデル().get台帳種別());
            //表示 台帳種別名
            row.setDaichoShubetsu(new RString(DaichoType.toValue(model.get介護保険施設入退所モデル().get台帳種別()).toString()));
            //非表示 施設種類key
            row.setShisetsuShuruiKey(model.get介護保険施設入退所モデル().get入所施設種類());
            //表示 施設種類名
            row.setShisetsuShurui(new RString(ShisetsuType.toValue(model.get介護保険施設入退所モデル().get入所施設種類()).toString()));

            dataSource.add(row);

        }

        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setDataSource(dataSource);
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
