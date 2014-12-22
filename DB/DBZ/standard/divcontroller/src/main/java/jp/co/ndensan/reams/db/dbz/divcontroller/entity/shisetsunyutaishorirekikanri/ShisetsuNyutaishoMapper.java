/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N3327 三浦 凌
 */
public class ShisetsuNyutaishoMapper {

    private ShisetsuNyutaishoMapper() {
    }

    /**
     * {@link dgShisetsuNyutaishoRireki_Row}に含まれる{@link ShisetsuNyutaishoRelateModel}を特定できるキーを返します。
     *
     * @param rowValue {@link dgShisetsuNyutaishoRireki_Row}
     * @return {@link ShisetsuNyutaishoRelateModel}を特定できるキー
     */
    public static IPredicate<ShisetsuNyutaishoRelateModel> createKey(final dgShisetsuNyutaishoRireki_Row rowValue) {
        return new IPredicate<ShisetsuNyutaishoRelateModel>() {
            @Override

            public boolean evaluate(ShisetsuNyutaishoRelateModel t) {
                return hasSame施設コード(t) && hasSame入所日(t) && hasSame退所日(t);
            }

            private boolean hasSame施設コード(ShisetsuNyutaishoRelateModel t) {
                return t.get介護保険施設入退所モデル().get入所施設コード().equals(rowValue.getShisetsuCode());
            }

            private boolean hasSame入所日(ShisetsuNyutaishoRelateModel t) {
                return t.get介護保険施設入退所モデル().get入所年月日().equals(rowValue.getNyushoDate().getValue());
            }

            private boolean hasSame退所日(ShisetsuNyutaishoRelateModel t) {
                return t.get介護保険施設入退所モデル().get退所年月日().equals(rowValue.getTaishoDate().getValue());
            }
        };
    }

    static IConsumer<ShisetsuNyutaishoRelateModel> merge(final ShisetsuNyutaishoRelateModel model) {
        return new IConsumer<ShisetsuNyutaishoRelateModel>() {
            @Override
            public void accept(ShisetsuNyutaishoRelateModel t) {
                t.get介護保険施設入退所モデル().setDeletedState(false);
                t.get介護保険施設入退所モデル().set入所年月日(model.get介護保険施設入退所モデル().get入所年月日());
                t.get介護保険施設入退所モデル().set退所年月日(model.get介護保険施設入退所モデル().get退所年月日());
                t.get介護保険施設入退所モデル().set入所施設コード(model.get介護保険施設入退所モデル().get入所施設コード());
                t.setJigyoshaMeisho(model.getJigyoshaMeisho());
            }
        };
    }

    static IConsumer<ShisetsuNyutaishoRelateModel> delete() {
        return new IConsumer<ShisetsuNyutaishoRelateModel>() {
            @Override
            public void accept(ShisetsuNyutaishoRelateModel t) {
                t.get介護保険施設入退所モデル().setDeletedState(true);
            }
        };
    }

    /**
     *
     * @return
     */
    static IFunction<ShisetsuNyutaishoRelateModel, dgShisetsuNyutaishoRireki_Row> toGridRow() {
        return new IFunction<ShisetsuNyutaishoRelateModel, dgShisetsuNyutaishoRireki_Row>() {
            @Override
            public dgShisetsuNyutaishoRireki_Row apply(ShisetsuNyutaishoRelateModel model) {
                dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row(
                        RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

                row.setState(getModelStateValue(model));
                row.getNyushoDate().setValue(model.get介護保険施設入退所モデル().get入所年月日());
                row.getTaishoDate().setValue(model.get介護保険施設入退所モデル().get退所年月日());
                row.setShisetsuCode(model.get介護保険施設入退所モデル().get入所施設コード());
                row.setShisetsuMeisho(model.getJigyoshaMeisho());
                row.setShisetsu(compose施設(model));
                //row.setShisetsu(model.get介護保険施設入退所モデル().get入所施設コード().concat(":").concat(model.getJigyoshaMeisho()));
                row.setDaichoShubetsuKey(model.get介護保険施設入退所モデル().get台帳種別());
                row.setDaichoShubetsu(new RString(DaichoType.toValue(model.get介護保険施設入退所モデル().get台帳種別()).toString()));
                row.setShisetsuShuruiKey(model.get介護保険施設入退所モデル().get入所施設種類());
                row.setShisetsuShurui(new RString(ShisetsuType.toValue(model.get介護保険施設入退所モデル().get入所施設種類()).toString()));
                return row;
            }
        };
    }

    private static RString compose施設(ShisetsuNyutaishoRelateModel model) {
        RString 施設コード = model.get介護保険施設入退所モデル().get入所施設コード();
        RString 施設名 = model.getJigyoshaMeisho();
        return new RStringBuilder()
                .append((施設コード == null) ? RString.EMPTY : 施設コード)
                //  .append((施設コード != null && 施設名 != null) ? ":" : RString.EMPTY)
                .append((施設コード == null) ? RString.EMPTY : ":")
                .append((施設名 == null) ? RString.EMPTY : 施設名)
                .toRString();
    }

    private static RString getModelStateValue(ShisetsuNyutaishoRelateModel model) {
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

    public static ShisetsuNyutaishoRelateModel toShisetsuNyutaishoRelateModel(ShisetsuNyutaishoRirekiKanriDiv div) {
        ShisetsuNyutaishoRelateModel model = new ShisetsuNyutaishoRelateModel();
        model.get介護保険施設入退所モデル().set入所年月日(getValueOrDefault(div.getShisetsuNyutaishoInput().getTxtNyushoDate(), FlexibleDate.EMPTY));
        model.get介護保険施設入退所モデル().set退所年月日(getValueOrDefault(div.getShisetsuNyutaishoInput().getTxtTaishoDate(), FlexibleDate.EMPTY));
        model.get介護保険施設入退所モデル().set入所施設コード(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get入所施設コード().value());
        model.setJigyoshaMeisho(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設名称());
        model.get介護保険施設入退所モデル().set台帳種別(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().get().getCode());
        model.get介護保険施設入退所モデル().set入所施設種類(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類().getCode());
        return model;
    }

    private static FlexibleDate getValueOrDefault(TextBoxFlexibleDate txtDate, FlexibleDate defaultValue) {
        return (txtDate.getValue() == null) ? defaultValue : txtDate.getValue();
    }
}
