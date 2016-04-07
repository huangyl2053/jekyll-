/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度のNullObjectです。
 */
final class NendoEmpty implements INendo {

    private NendoEmpty() {
    }

    @Override
    public boolean between(FlexibleDate 基準日) {
        return false;
    }

    @Override
    public FlexibleYear getYear() {
        return FlexibleYear.EMPTY;
    }

    @Override
    public FlexibleDate get終了日() {
        return FlexibleDate.EMPTY;
    }

    @Override
    public FlexibleDate get開始日() {
        return FlexibleDate.EMPTY;
    }

    /**
     * 空の年度を返却します。
     *
     * @return 空の年度
     */
    static NendoEmpty getInstance() {
        return InsatnceHolder.Holder.getInstance();
    }

    @Override
    public INendo before() {
        return this;
    }

    private enum InsatnceHolder {

        Holder;
        private final NendoEmpty instance;

        private InsatnceHolder() {
            instance = new NendoEmpty();
        }

        public NendoEmpty getInstance() {
            return instance;
        }
    }
}
