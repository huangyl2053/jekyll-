/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.GogitaiDetailMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.GogitaiJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合議体の詳細な情報を取得するためのFinderです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiDetailFinder {

    private GogitaiJohoDac 合議体情報Dac;
    private final ShinsakaiKaisaiBashoManager 開催場所Manager;

    /**
     * インスタンスを生成します。
     */
    public GogitaiDetailFinder() {
        合議体情報Dac = InstanceProvider.create(GogitaiJohoDac.class);
        開催場所Manager = new ShinsakaiKaisaiBashoManager();
    }

    /**
     * テスト用コンストラクタです。引数からテストで必要なクラスを受け取り、インスタンスを生成します。
     *
     * @param 合議体情報Dac
     * @param 開催場所Manager
     */
    GogitaiDetailFinder(GogitaiJohoDac 合議体情報Dac, ShinsakaiKaisaiBashoManager 開催場所Manager) {
        this.合議体情報Dac = 合議体情報Dac;
        this.開催場所Manager = 開催場所Manager;
    }

    /**
     * 合議体番号と基準年月日を指定し、現在有効な合議体の情報を一件取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 基準年月日 基準年月日
     * @return 合議体情報
     */
    public GogitaiDetail get合議体情報(GogitaiNo 合議体番号, FlexibleDate 基準年月日) {
        DbT5103GogitaiJohoEntity entity = 合議体情報Dac.select(合議体番号, 基準年月日);
        ShinsakaiKaisaiBasho 開催場所 =
                開催場所Manager.get審査会開催場所(new ShinsakaiKaisaiBashoCode(entity.getShinsakaiKaisaiBashoCode()));
        return GogitaiDetailMapper.to合議体情報(entity, 開催場所);
    }
}
