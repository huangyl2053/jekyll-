/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri;

import jp.co.ndensan.reams.db.dba.entity.db.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 資格取得除外者一覧取得します
 */
public class ShikakuShutokuJogaishaKanri {

    private final ShikakuShutokuJogaishaKanriEntity shikakuShutokuJogaishaKanriEntity;

    /**
     * 資格取得除外者一覧取得のEntity
     *
     * @param shikakuShutokuJogaishaKanriEntity ShikakuShutokuJogaishaKanriEntity
     */
    public ShikakuShutokuJogaishaKanri(ShikakuShutokuJogaishaKanriEntity shikakuShutokuJogaishaKanriEntity) {
        this.shikakuShutokuJogaishaKanriEntity = shikakuShutokuJogaishaKanriEntity;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shikakuShutokuJogaishaKanriEntity.getShichosonCode();
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikakuShutokuJogaishaKanriEntity.getShikibetsuCode();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return shikakuShutokuJogaishaKanriEntity.getRirekiNo();
    }

    /**
     * 氏名のgetメソッドです。
     *
     * @return 氏名
     */
    public AtenaMeisho getMeisho() {
        return shikakuShutokuJogaishaKanriEntity.getMeisho();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return shikakuShutokuJogaishaKanriEntity.getSeinengappiYMD();
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    public RString getSeibetsuCode() {
        return shikakuShutokuJogaishaKanriEntity.getSeibetsuCode();
    }

    /**
     * 住民状態のgetメソッドです。
     *
     * @return 住民状態
     */
    public RString getJuminJotaiCode() {
        return shikakuShutokuJogaishaKanriEntity.getJuminJotaiCode();
    }

    /**
     * 資格取得除外理由のgetメソッドです。
     *
     * @return 資格取得除外理由
     */
    public RString getShikakuShutokuJogaiRiyu() {
        return shikakuShutokuJogaishaKanriEntity.getShikakuShutokuJogaiRiyu();
    }

    /**
     * 資格取得除外年月日のgetメソッドです。
     *
     * @return 資格取得除外年月日
     */
    public FlexibleDate getShikakuShutokuJogaiYMD() {
        return shikakuShutokuJogaishaKanriEntity.getShikakuShutokuJogaiYMD();
    }

    /**
     * 資格取得除外解除年月日のgetメソッドです。
     *
     * @return 資格取得除外解除年月日
     */
    public FlexibleDate getShikakuShutokuJogaiKaijoYMD() {
        return shikakuShutokuJogaishaKanriEntity.getShikakuShutokuJogaiKaijoYMD();
    }

}
