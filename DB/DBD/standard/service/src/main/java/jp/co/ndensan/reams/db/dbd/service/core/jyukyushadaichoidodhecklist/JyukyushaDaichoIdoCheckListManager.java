/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.jyukyushadaichoidodhecklist;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳異動チェックリスト画面のManagerクラスです。
 *
 * @reamsid_L DBD-1770-010 donghj
 */
public class JyukyushaDaichoIdoCheckListManager {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public JyukyushaDaichoIdoCheckListManager() {
        this.dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbT7022ShoriDateKanriDac
     */
    public JyukyushaDaichoIdoCheckListManager(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 受給者台帳異動チェックリストManagerのIntanceを作成します。
     *
     * @return JyukyushaDaichoIdoCheckListManager
     */
    public static JyukyushaDaichoIdoCheckListManager createInstance() {
        return InstanceProvider.create(JyukyushaDaichoIdoCheckListManager.class);
    }

    /**
     * 対象期間前回を取得する。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get対象期間前回(SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度) {
        DbT7022ShoriDateKanriEntity entity = dac.select対象期間前回(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度);
        if (entity == null) {
            return null;
        } else {
            return new ShoriDateKanri(entity);
        }

    }
}
