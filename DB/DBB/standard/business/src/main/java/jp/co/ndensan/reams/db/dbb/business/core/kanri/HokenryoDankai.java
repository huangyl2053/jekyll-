/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階のクラスです。
 *
 * @reamsid_L DBB-9020-110 sunhaidi
 */
public class HokenryoDankai {

    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");
    private final DbT2013HokenryoDankaiEntity entity;
    private RString 表記 = RString.EMPTY;

    /**
     * コンストラクタです。
     *
     * @param entity 保険料段階テーブルのエンティティ
     */
    public HokenryoDankai(DbT2013HokenryoDankaiEntity entity) {
        this.entity = entity;
        if (!RString.isNullOrEmpty(entity.getDankaiKubun())) {
            int 段階数値 = Integer.parseInt(entity.getDankaiKubun().substring(0, 2).toString());
            RStringBuilder 表記SB = new RStringBuilder();
            表記SB.append(文字列_第);
            表記SB.append(段階数値);
            表記SB.append(文字列_段階);
            表記SB.append(entity.getTokureiHyoki());
            表記 = 表記SB.toRString();
        }
    }

    /**
     * 保険料率を返します。
     *
     * @return 保険料率
     */
    public Decimal get保険料率() {
        return entity.getHokenryoRitsu();
    }

    /**
     * 保険料段階の表示名を返します。
     *
     * @return 表示名
     */
    public RString get表記() {
        return 表記;
    }

    /**
     * 段階区分を返します。
     *
     * @return 段階区分
     */
    public RString get段階区分() {
        return entity.getDankaiKubun();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return entity.getRankuKubun();
    }

    /**
     * 段階Indexを返します。
     *
     * @return 段階Index
     */
    public RString get段階Index() {
        return entity.getDankaiIndex();
    }
}
