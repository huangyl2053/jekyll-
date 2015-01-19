/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 被保険者モデルと資格変更DataGrid_Rowのマッピングを行います。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoMapper {

    private ShikakuHenkoMapper() {
    }

    /**
     * {@link dgHenko_Row}に含まれる{@link HihokenshaDaichoModel}を特定できるキーを返します。
     *
     * @param rowValue {@link dgHenko_Row}
     * @return {@link HihokenshaDaichoModel}を特定できるキー
     */
    public static IPredicate<HihokenshaDaichoModel> createKey(final dgHenko_Row rowValue) {
        return new IPredicate<HihokenshaDaichoModel>() {
            @Override
            public boolean evaluate(HihokenshaDaichoModel t) {
                return hasSame資格変更事由(t) && hasSame資格変更年月日(t) && hasSame資格変更届出年月日(t);
            }

            private boolean hasSame資格変更事由(HihokenshaDaichoModel t) {
                return t.get資格変更事由().getCode().equals(rowValue.getHenkoJiyuKey());
            }

            private boolean hasSame資格変更年月日(HihokenshaDaichoModel t) {
                return t.get資格変更年月日().equals(rowValue.getHenkoDate().getValue());
            }

            private boolean hasSame資格変更届出年月日(HihokenshaDaichoModel t) {
                return t.get資格変更届出年月日().equals(rowValue.getHenkoTodokedeDate().getValue());
            }
        };
    }

    static IConsumer<HihokenshaDaichoModel> merge(final HihokenshaDaichoModel model) {
        return new IConsumer<HihokenshaDaichoModel>() {
            @Override
            public void accept(HihokenshaDaichoModel t) {
                t.setDeletedState(false);
                t.set資格変更年月日(model.get資格変更年月日());
                t.set資格変更届出年月日(model.get資格変更届出年月日());
                t.set資格変更事由(model.get資格変更事由());
                t.set旧市町村コード(model.get旧市町村コード());
            }
        };
    }

    static IConsumer<HihokenshaDaichoModel> delete() {
        return new IConsumer<HihokenshaDaichoModel>() {
            @Override
            public void accept(HihokenshaDaichoModel t) {
                t.setDeletedState(true);
            }
        };
    }

    static IFunction<HihokenshaDaichoModel, dgHenko_Row> toGridRow() {
        return new IFunction<HihokenshaDaichoModel, dgHenko_Row>() {
            @Override
            public dgHenko_Row apply(HihokenshaDaichoModel model) {
                dgHenko_Row row = new dgHenko_Row(
                        RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate());

                TextBoxFlexibleDate shoriDate = new TextBoxFlexibleDate();
                shoriDate.setValue(new FlexibleDate(model.get処理日時().getDate().toString()));

                row.setState(getModelStateValue(model));
                row.setShoriDate(shoriDate);
                row.setHenkoJiyuKey(model.get資格変更事由().getCode());
                row.setHenkoJiyu(model.get資格変更事由().getShortName());
                row.getHenkoDate().setValue(model.get資格変更年月日());
                row.getHenkoTodokedeDate().setValue(model.get資格変更届出年月日());
                row.setKyuHokensha(Kyuhokensha.toValue(model.get旧市町村コード().getColumnValue()).getName());
                row.setSochimotoHokensha(model.get広住特措置元市町村コード().getColumnValue());
                return row;
            }
        };
    }

    private static RString getModelStateValue(HihokenshaDaichoModel model) {
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

    public static HihokenshaDaichoModel toHihokenshaDaichoModel(ShikakuHenkoRirekiDiv div) {
        HihokenshaDaichoModel model = new HihokenshaDaichoModel();
        model.set資格変更年月日(div.getTxtHenkoDate().getValue());
        model.set資格変更届出年月日(div.getTxtHenkoTodokedeDate().getValue());
        model.set資格変更事由(ShikakuHenkoJiyu.toValue(div.getDdlHenkoJiyu().getSelectedKey()));
        model.set広住特措置元市町村コード(new LasdecCode(div.getDdlHenkoSochimotoHokensha().getSelectedKey()));
        model.set旧市町村コード(new LasdecCode(div.getDdlHenkoKyuHokensha().getSelectedKey()));

        return model;
    }

}
