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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
     * {@link dgShisetsuNyutaishoRireki_Row}に含まれる{@link DbT1004ShisetsuNyutaishoEntity}を特定できるキーを返します。
     *
     * @param rowValue {@link dgShisetsuNyutaishoRireki_Row}
     * @return {@link DbT1004ShisetsuNyutaishoEntity}を特定できるキー
     */
    public static IPredicate<DbT1004ShisetsuNyutaishoEntity> createKey(final dgShisetsuNyutaishoRireki_Row rowValue) {
        return new IPredicate<DbT1004ShisetsuNyutaishoEntity>() {
            @Override

            public boolean evaluate(DbT1004ShisetsuNyutaishoEntity t) {
                return hasSame施設コード(t) && hasSame入所日(t) && hasSame退所日(t);
            }

            private boolean hasSame施設コード(DbT1004ShisetsuNyutaishoEntity t) {
                return t.getNyushoShisetsuCode().value().equals(rowValue.getShisetsuCode());
            }

            private boolean hasSame入所日(DbT1004ShisetsuNyutaishoEntity t) {
                return t.getNyushoYMD().equals(rowValue.getNyushoDate().getValue());
            }

            private boolean hasSame退所日(DbT1004ShisetsuNyutaishoEntity t) {
                return t.getTaishoYMD().equals(rowValue.getTaishoDate().getValue());
            }
        };
    }

    static IConsumer<DbT1004ShisetsuNyutaishoEntity> merge(final DbT1004ShisetsuNyutaishoEntity model) {
        return new IConsumer<DbT1004ShisetsuNyutaishoEntity>() {
            @Override
            public void accept(DbT1004ShisetsuNyutaishoEntity t) {
                t.setIsDeleted(false);
                t.setNyushoYMD(model.getNyushoYMD());
                t.setTaishoYMD(model.getTaishoYMD());
                t.setNyushoShisetsuCode(model.getNyushoShisetsuCode());
//                t.setJigyoshaMeisho(model.getJigyoshaMeisho());
            }
        };
    }

    static IConsumer<DbT1004ShisetsuNyutaishoEntity> delete() {
        return new IConsumer<DbT1004ShisetsuNyutaishoEntity>() {
            @Override
            public void accept(DbT1004ShisetsuNyutaishoEntity t) {
                t.setIsDeleted(true);
            }
        };
    }

    /**
     *
     * @return
     */
    static IFunction<DbT1004ShisetsuNyutaishoEntity, dgShisetsuNyutaishoRireki_Row> toGridRow() {
        return new IFunction<DbT1004ShisetsuNyutaishoEntity, dgShisetsuNyutaishoRireki_Row>() {
            @Override
            public dgShisetsuNyutaishoRireki_Row apply(DbT1004ShisetsuNyutaishoEntity model) {
                dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row(
                        RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

                row.setState(getModelStateValue(model));
                row.getNyushoDate().setValue(model.getNyushoYMD());
                row.getTaishoDate().setValue(model.getTaishoYMD());
                row.setShisetsuCode(model.getNyushoShisetsuCode().value());
//                row.setShisetsuMeisho(model.getJigyoshaMeisho());
                row.setShisetsu(compose施設(model));
                row.setDaichoShubetsuKey(model.getDaichoShubetsu());
                row.setDaichoShubetsu(new RString(DaichoType.toValue(model.getDaichoShubetsu()).toString()));
                row.setShisetsuShuruiKey(model.getNyushoShisetsuShurui());
                row.setShisetsuShurui(new RString(ShisetsuType.toValue(model.getNyushoShisetsuShurui()).toString()));
                return row;
            }
        };
    }

    private static RString compose施設(DbT1004ShisetsuNyutaishoEntity model) {
        RString 施設コード = model.getNyushoShisetsuCode().value();
        RString 施設種類 = model.getNyushoShisetsuShurui();
        return new RStringBuilder()
                .append((施設コード == null) ? RString.EMPTY : 施設コード)
                .append((施設コード != null) ? "：" : RString.EMPTY)
                .append((施設種類 == null) ? RString.EMPTY : 施設種類)
                .toRString();
    }

    private static RString getModelStateValue(DbT1004ShisetsuNyutaishoEntity model) {
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

    public static DbT1004ShisetsuNyutaishoEntity toDbT1004ShisetsuNyutaishoEntity(ShisetsuNyutaishoRirekiKanriDiv div) {
        DbT1004ShisetsuNyutaishoEntity model = new DbT1004ShisetsuNyutaishoEntity();
        model.setNyushoYMD(getValueOrDefault(div.getShisetsuNyutaishoInput().getTxtNyushoDate(), FlexibleDate.EMPTY));
        model.setTaishoYMD(getValueOrDefault(div.getShisetsuNyutaishoInput().getTxtTaishoDate(), FlexibleDate.EMPTY));
        model.setDaichoShubetsu(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get台帳種別().get().getCode());
        model.setNyushoShisetsuShurui(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類().getCode());

        model.setShikibetsuCode(new ShikibetsuCode(div.getShikibetsuCode()));
        model.setShichosonCode(new LasdecCode(div.getShichosonCode()));
        return model;
    }

    private static FlexibleDate getValueOrDefault(TextBoxFlexibleDate txtDate, FlexibleDate defaultValue) {
        return (txtDate.getValue() == null) ? defaultValue : txtDate.getValue();
    }
}
