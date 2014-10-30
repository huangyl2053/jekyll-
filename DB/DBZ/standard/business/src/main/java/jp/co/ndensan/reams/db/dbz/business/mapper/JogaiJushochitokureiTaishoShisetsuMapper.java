/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.mapper;

import jp.co.ndensan.reams.db.dbz.business.JogaiJushochitokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護除外・住所地特例対象施設のbusinessクラスとentityクラスのマッピングを行うクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class JogaiJushochitokureiTaishoShisetsuMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private JogaiJushochitokureiTaishoShisetsuMapper() {
    }

    /**
     * 介護除外・住所地特例対象施設entityをbusinessの介護除外・住所地特例対象施設クラスにマッピングします。<br/>
     * 引数にnullが渡されたときは、nullを返します。
     *
     * @param entity 介護除外・住所地特例対象施設
     * @return businessの介護除外・住所地特例対象施設クラス
     */
    public static JogaiJushochitokureiTaishoShisetsu to除外_住所地特例対象施設(
            DbT1005KaigoJogai_TokureiTaishoShisetsuEntity entity) {

        if (entity == null) {
            return null;
        }
        JogaiJushochitokureiTaishoShisetsu 除外_住所地特例対象施設 = new JogaiJushochitokureiTaishoShisetsu(
                create施設種類(entity.getNyushoShisetsuShurui()),
                create施設コード(entity.getNyushoShisetsuCode()),
                entity.getShoriTimestamp(),
                create有効期間(entity),
                entity.getShikibetsuCode(),
                entity.getShisetsuRyakusho(),
                entity.getShisetsuKanaRyakusho(),
                entity.getShisetsuKanaJusho(),
                entity.getIdoJiyuCode(),
                entity.getIdoYMD(),
                entity.getHojinShubetsuCode(),
                entity.getShisetsuKaishiYMD(),
                entity.getShisetsuKyushiYMD(),
                entity.getShisetsuHaishiYMD(),
                entity.getShisetsuSaikaiYMD()
        );
        return 除外_住所地特例対象施設;
    }

    private static ShisetsuType create施設種類(RString code) {
        return ShisetsuType.toValue(code);
    }

    private static ShisetsuCode create施設コード(RString code) {
        return new ShisetsuCode(code);
    }

    private static Range<FlexibleDate> create有効期間(DbT1005KaigoJogai_TokureiTaishoShisetsuEntity entity) {
        FlexibleDate start = entity.getYukoKaishiYMD();
        FlexibleDate end = entity.getYukoShuryoYMD();
        Range 期間 = new Range(start, end);

        return 期間;
    }
}
