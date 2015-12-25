/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.shikaku;

import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.OrderValidator;
import jp.co.ndensan.reams.uz.uza.core.validation.PresenceValidator;

/**
 *
 * @author LDNS chenty
 */
public enum ShikakuHenkoSpec implements IPredicate<ShikakuHenko> {

    /**
     * 変更日が入力であること
     */
    変更日が入力であること {
                @Override
                public boolean apply(ShikakuHenko nothing) {
                    boolean res = false;
                    if (!PresenceValidator.isValid(nothing.get変更日())) {
                        res = true;
                    }
                    return res;
                }
            },
    /**
     * 変更事由が入力であること
     */
    変更事由が入力であること {
                @Override
                public boolean apply(ShikakuHenko nothing) {
                    boolean res = false;
                    if (!PresenceValidator.isValid(nothing.get変更事由())) {
                        res = true;
                    }
                    return res;
                }
            },
    /**
     * 取得日が変更日より前
     */
    取得日が変更日より前 {
                @Override
                public boolean apply(ShikakuHenko nothing) {
                    if (nothing.get変更日().isEmpty() || nothing.get取得日().isEmpty()) {
                        return false;
                    }
                    return nothing.get変更日().isBefore(nothing.get取得日());
                }
            },
    /**
     * 喪失日が変更日より後
     */
    喪失日が変更日より後 {
                @Override
                public boolean apply(ShikakuHenko nothing) {
                    if (nothing.get喪失日().isEmpty() || nothing.get取得日().isEmpty()) {
                        return false;
                    }
                    return !nothing.get変更日().isBefore(nothing.get喪失日());
                }
            },
    /**
     * 変更日が次の履歴データの変更日以降
     */
    変更日が次の履歴データの変更日以降 {
                @Override
                public boolean apply(ShikakuHenko nothing) {

                    Optional<DbT1001HihokenshaDaichoEntity> optional = nothing.get次履歴();
                    DbT1001HihokenshaDaichoEntity 次履歴 = optional.orElse(null);

                    if (次履歴 == null || nothing.get変更日().isEmpty()) {
                        return false;
                    }
                    return 次履歴.getShikakuHenkoYMD().isBefore(nothing.get変更日());
                }
            },
    /**
     * 変更日が前の履歴データの変更日以降
     */
    変更日が前の履歴データの変更日以降 {
                @Override
                public boolean apply(ShikakuHenko nothing) {

                    Optional<DbT1001HihokenshaDaichoEntity> optional = nothing.get前履歴();
                    DbT1001HihokenshaDaichoEntity 前履歴 = optional.orElse(null);

                    if (前履歴 == null || nothing.get変更日().isEmpty()) {
                        return false;
                    }
                    return !前履歴.getShikakuHenkoYMD().isBefore(nothing.get変更日());
                }
            },
    /**
     * has住所地特例履歴と期間が重複する履歴
     */
    has住所地特例履歴と期間が重複する履歴 {
                @Override
                public boolean apply(ShikakuHenko nothing) {

                    IItemList<DbT1001HihokenshaDaichoEntity> list = nothing.get全履歴();
                    if (nothing.get変更日().isEmpty()) {
                        return false;
                    }
                    for (DbT1001HihokenshaDaichoEntity model : list) {
                        if (model.getShikakuShutokuYMD().isEmpty() || model.getShikakuSoshitsuYMD().isEmpty()) {
                            return false;
                        }
                        if (OrderValidator.from(model.getShikakuShutokuYMD())
                        .afterOrEquals(nothing.get変更日())
                        .after(model.getShikakuSoshitsuYMD()).isValid()) {
                            return true;
                        }
                    }
                    return false;
                }
            },
    /**
     * is最新の取得日として登録不可
     */
    is最新の取得日として登録不可 {
                @Override
                public boolean apply(ShikakuHenko nothing) {
                    if (nothing.get最新資格喪失日().isEmpty()) {

                        if (nothing.get変更日().isBefore(nothing.get最新資格変更日())) {
                            return true;
                        }

                    } else {
                        if (!nothing.get最新資格変更日().isBeforeOrEquals(nothing.get最新資格喪失日())) {
                            return true;
                        }
                    }
                    return nothing.get最新資格変更日().isBefore(nothing.get最新資格取得日());
                }
            },
    /**
     * 変更事由が１号到達で年齢が65歳未満
     */
    変更事由が１号到達で年齢が65歳未満 {
                @Override
                public boolean apply(ShikakuHenko nothing) {
                    return nothing.get変更日().equals(nothing.get一号資格取得日());
                }
            },
}
