/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import static jp.co.ndensan.reams.uz.uza.util.db.EntityDataState.Added;
import static jp.co.ndensan.reams.uz.uza.util.db.EntityDataState.Deleted;
import static jp.co.ndensan.reams.uz.uza.util.db.EntityDataState.Modified;

/**
 * 被保険者モデルと資格変更DataGrid_Rowのマッピングを行います。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoMapper {

    private ShikakuHenkoMapper() {
    }

    /**
     * {@link dgHenko_Row}に含まれる{@link DbT1001HihokenshaDaichoEntity}を特定できるキーを返します。
     *
     * @param rowValue {@link dgHenko_Row}
     * @return {@link DbT1001HihokenshaDaichoEntity}を特定できるキー
     */
    public static IPredicate<DbT1001HihokenshaDaichoEntity> createKey(final dgHenko_Row rowValue) {
        return new IPredicate<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public boolean evaluate(DbT1001HihokenshaDaichoEntity t) {
                return hasSame資格変更事由(t) && hasSame資格変更年月日(t) && hasSame資格変更届出年月日(t);
            }

            private boolean hasSame資格変更事由(DbT1001HihokenshaDaichoEntity t) {
                return t.getShikakuHenkoJiyuCode().equals(rowValue.getHenkoJiyuKey());
            }

            private boolean hasSame資格変更年月日(DbT1001HihokenshaDaichoEntity t) {
                return t.getShikakuHenkoYMD().equals(rowValue.getHenkoDate().getValue());
            }

            private boolean hasSame資格変更届出年月日(DbT1001HihokenshaDaichoEntity t) {
                return t.getShikakuHenkoTodokedeYMD().equals(rowValue.getHenkoTodokedeDate().getValue());
            }
        };
    }

    static IConsumer<DbT1001HihokenshaDaichoEntity> merge(final DbT1001HihokenshaDaichoEntity model) {
        return new IConsumer<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public void accept(DbT1001HihokenshaDaichoEntity t) {
                t.setIsDeleted(false);
                t.setShikakuHenkoYMD(model.getShikakuHenkoYMD());
                t.setShikakuHenkoTodokedeYMD(model.getShikakuHenkoTodokedeYMD());
                t.setShikakuHenkoJiyuCode(model.getShikakuHenkoJiyuCode());
                t.setKyuShichosonCode(model.getKyuShichosonCode());
            }
        };
    }

    static IConsumer<DbT1001HihokenshaDaichoEntity> delete() {
        return new IConsumer<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public void accept(DbT1001HihokenshaDaichoEntity t) {
                t.setIsDeleted(true);
            }
        };
    }

    static IFunction<DbT1001HihokenshaDaichoEntity, dgHenko_Row> toGridRow() {
        return new IFunction<DbT1001HihokenshaDaichoEntity, dgHenko_Row>() {
            @Override
            public dgHenko_Row apply(DbT1001HihokenshaDaichoEntity model) {
                dgHenko_Row row = new dgHenko_Row(
                        RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate());

                TextBoxFlexibleDate shoriDate = new TextBoxFlexibleDate();
                shoriDate.setValue(model.getIdoYMD());

                row.setState(getModelStateValue(model));
                row.setShoriDate(shoriDate);

                //TODO n8178 城間篤人 資格変更事由にはEMPTYが入る可能性があるが、コードがそれを考慮する形になっていないためif文で仮対応。
                //該当する項目が存在しない場合の動作が決まった後に修正。
                if (!model.getShikakuHenkoJiyuCode().isEmpty()) {
                    row.setHenkoJiyuKey(model.getShikakuHenkoJiyuCode());
                    row.setHenkoJiyu(model.getShikakuHenkoJiyuCode());
                }
                row.getHenkoDate().setValue(model.getShikakuHenkoYMD());
                row.getHenkoTodokedeDate().setValue(model.getShikakuHenkoTodokedeYMD());
                //TODO n8178 城間篤人 旧保険者を取得する方法は用意されたため、この代替実装は不要になる。後日置き換えが必要
                //row.setKyuHokensha(Kyuhokensha.toValue(model.get旧市町村コード().getColumnValue()).getName());
                row.setSochimotoHokensha(model.getKoikinaiTokureiSochimotoShichosonCode().getColumnValue());
                return row;
            }
        };
    }

    private static RString getModelStateValue(DbT1001HihokenshaDaichoEntity model) {
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

    public static DbT1001HihokenshaDaichoEntity toDbT1001HihokenshaDaichoEntity(ShikakuHenkoRirekiDiv div) {
        DbT1001HihokenshaDaichoEntity model = new DbT1001HihokenshaDaichoEntity();
        model.setShikakuHenkoYMD(div.getTxtHenkoDate().getValue());
        model.setShikakuHenkoTodokedeYMD(div.getTxtHenkoTodokedeDate().getValue());
        model.setShikakuHenkoJiyuCode(div.getDdlHenkoJiyu().getSelectedKey());
        model.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(div.getDdlHenkoSochimotoHokensha().getSelectedKey()));
        model.setKyuShichosonCode(new LasdecCode(div.getDdlHenkoKyuHokensha().getSelectedKey()));

        return model;
    }

}
