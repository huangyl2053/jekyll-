/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyu;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い支給（不支給）決定通知書一括作成を管理するクラスです。
 *
 * @reamsid_L DBC-1000-010 zhangzhiming
 */
public class ShokanbaraiShikyuFinder {

    private final DbT7022ShoriDateKanriDac dbt7022Dac;
    private final DbT7068ChohyoBunruiKanriDac dbt7068Dac;

    /**
     * コンストラクタです。
     */
    ShokanbaraiShikyuFinder() {
        this.dbt7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.dbt7068Dac = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbt7022Dac DbT7022ShoriDateKanriDac
     * @param dbt7068Dac DbT7068ChohyoBunruiKanriDac
     */
    ShokanbaraiShikyuFinder(DbT7022ShoriDateKanriDac dbt7022Dac, DbT7068ChohyoBunruiKanriDac dbt7068Dac) {
        this.dbt7022Dac = dbt7022Dac;
        this.dbt7068Dac = dbt7068Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShokanbaraiShikyuFinder}のインスタンスを返します。
     *
     * @return *
     * {@link InstanceProvider#create}にて生成した{@link ShokanbaraiShikyuFinder}のインスタンス
     */
    public static ShokanbaraiShikyuFinder createInstance() {
        return InstanceProvider.create(ShokanbaraiShikyuFinder.class);
    }

    /**
     * 前回対象日を取得します。
     *
     * @param 処理名 処理名
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri select前回対象日(RString 処理名) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = association.get地方公共団体コード();
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.select前回対象日(市町村コード, 処理名);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * 帳票分類IDを取得します。
     *
     * @return ChohyoBunruiKanri
     */
    @Transaction
    public ChohyoBunruiKanri select帳票分類ID() {
        DbT7068ChohyoBunruiKanriEntity entity = dbt7068Dac.selectByKey(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002.getReportId());
        if (entity != null) {
            return new ChohyoBunruiKanri(entity);
        }
        return null;
    }
}
