/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kaigiatesakijushosettei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護宛先住所設定クラスです。
 *
 * @reamsid_L DBU-3990-030 wanghui
 */
public class KaigoAtesakiJushoSetteiFinder {

    private final DbT7065ChohyoSeigyoKyotsuDac dbT7065dac;
    private final DbT7908KaigoDonyuKeitaiDac dbT7908dac;

    /**
     * コンストラクタです。
     */
    public KaigoAtesakiJushoSetteiFinder() {
        this.dbT7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.dbT7908dac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT7065ChohyoSeigyoKyotsuDac dbT7065dac
     * @param DbT7908KaigoDonyuKeitaiDac dbT7908dac
     */
    KaigoAtesakiJushoSetteiFinder(
            DbT7065ChohyoSeigyoKyotsuDac dbT7065dac,
            DbT7908KaigoDonyuKeitaiDac dbT7908dac) {
        this.dbT7065dac = dbT7065dac;
        this.dbT7908dac = dbT7908dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoKyotsuControFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoAtesakiJushoSetteiFinder}のインスタンス
     */
    public static KaigoAtesakiJushoSetteiFinder createInstance() {
        return InstanceProvider.create(KaigoAtesakiJushoSetteiFinder.class);
    }

    /**
     * 介護導入形態Listをセットする。
     *
     * @return 介護導入形態List
     */
    @Transaction
    public SearchResult<KaigoDonyuKeitai> select介護導入形態() {
        List<KaigoDonyuKeitai> 介護導入形態List = new ArrayList<>();
        List<DbT7908KaigoDonyuKeitaiEntity> keitaiLsit = dbT7908dac.selectAll();
        if (keitaiLsit == null || keitaiLsit.isEmpty()) {
            return SearchResult.of(Collections.<KaigoDonyuKeitai>emptyList(), 0, false);
        }
        for (DbT7908KaigoDonyuKeitaiEntity 介護導入形態 : keitaiLsit) {
            介護導入形態List.add(new KaigoDonyuKeitai(介護導入形態));
        }
        return SearchResult.of(介護導入形態List, 0, false);
    }

    /**
     * 介護導入形態Listをセットする。
     *
     * @param サブ業務コード RString
     * @param 帳票分類ID RString
     * @return kyotsuEntity
     */
    @Transaction
    public DbT7065ChohyoSeigyoKyotsuEntity select帳票制御共通(RString サブ業務コード, RString 帳票分類ID) {
        DbT7065ChohyoSeigyoKyotsuEntity kyotsuEntity = dbT7065dac.selectByKey(new SubGyomuCode(サブ業務コード.toString()), new ReportId(帳票分類ID.toString()));
        if (kyotsuEntity == null) {
            return null;
        }
        return kyotsuEntity;

    }
}
