/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階のクラスです。
 */
public class HokenryoDankai {

    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");
    private final DbT2013HokenryoDankaiEntity entity;
    private int 段階数値 = 0;

    /**
     * コンストラクタです。
     *
     * @param entity 保険料段階テーブルのエンティティ
     */
    public HokenryoDankai(DbT2013HokenryoDankaiEntity entity) {
        this.entity = entity;
        if (!RString.isNullOrEmpty(entity.getDankaiKubun())) {
            段階数値 = Integer.parseInt(entity.getDankaiKubun().substring(0, 2).toString());
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

        if (!RString.isNullOrEmpty(entity.getDankaiKubun())) {
            RStringBuilder 表記 = new RStringBuilder();
            表記.append(文字列_第);
            表記.append(段階数値);
            表記.append(文字列_段階);
            return 表記.toRString();
        } else {
            return RString.EMPTY;
        }
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
    public RankKubun getランク区分() {
        return entity.getRankuKubun();
    }

    /**
     * 段階数値を返します。
     *
     * @return 段階数値
     */
    public int get段階数値() {
        return 段階数値;
    }
}
