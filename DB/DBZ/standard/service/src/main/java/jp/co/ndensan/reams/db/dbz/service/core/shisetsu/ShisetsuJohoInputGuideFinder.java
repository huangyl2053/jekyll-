/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shisetsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.business.core.shisetujyoho.KaigoJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.business.core.shisetujyoho.KaigoJogaiTokureiTaishoShisetsuInputGuide;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 入所施設名称取得のクラス。
 *
 * @reamsid_L DBA-0190-010 houtianpeng
 */
public class ShisetsuJohoInputGuideFinder {

    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005Dac;
    private final DbT7060KaigoJigyoshaDac dbT7060Dac;

    /**
     * コンストラクタ。
     *
     */
    public ShisetsuJohoInputGuideFinder() {

        this.dbT1005Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
        this.dbT7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT1005Dac DbT1005KaigoJogaiTokureiTaishoShisetsuDac
     * @param dbT7060Dac DbT7060KaigoJigyoshaDac
     */
    ShisetsuJohoInputGuideFinder(DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005Dac,
            DbT7060KaigoJigyoshaDac dbT7060Dac) {
        this.dbT1005Dac = dbT1005Dac;
        this.dbT7060Dac = dbT7060Dac;
    }

    /**
     * 介護事業者情報を取得します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @return List<KaigoJigyoshaInputGuide> 介護事業者取得リスト
     */
    @Transaction
    public SearchResult<KaigoJigyoshaInputGuide> getKaigoJigyoshaInputGuide(JigyoshaNo 事業者番号) {
        List<KaigoJigyoshaInputGuide> kaigoJigyoshaList = new ArrayList<>();
        List<DbT7060KaigoJigyoshaEntity> dbT7060List = dbT7060Dac.select介護事業者(事業者番号);
        if (dbT7060List == null || dbT7060List.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (DbT7060KaigoJigyoshaEntity entity : dbT7060List) {
            kaigoJigyoshaList.add(new KaigoJigyoshaInputGuide(entity));
        }
        return SearchResult.of(kaigoJigyoshaList, 0, false);
    }

    /**
     * 介護除外住所地特例対象施設を取得します。
     *
     * @param 事業者種別 RString
     * @return List<KaigoJogaiTokureiTaishoShisetsuInputGuide> 介護除外住所地特例対象施設リスト
     */
    @Transaction
    public SearchResult<KaigoJogaiTokureiTaishoShisetsuInputGuide> getKaigoJogaiTokureiTaishoShisetsuInputGuide(
            RString 事業者種別,RString 事業者番号) {
        List<KaigoJogaiTokureiTaishoShisetsuInputGuide> taishoShisetsuList = new ArrayList<>();
        List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> dbT1005List = dbT1005Dac.
                select介護除外住所地特例対象施設(事業者種別,事業者番号);
        if (dbT1005List == null || dbT1005List.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJogaiTokureiTaishoShisetsuInputGuide>emptyList(), 0, false);
        }
        for (DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity : dbT1005List) {
            taishoShisetsuList.add(new KaigoJogaiTokureiTaishoShisetsuInputGuide(entity));
        }
        return SearchResult.of(taishoShisetsuList, 0, false);
    }
}
