/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri;

import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得除外者一覧取得します。
 *
 * @reamsid_L DBA-0440-010 wangxiaodong
 */
public class ShikakuShutokuJogaishaKanri {

    private final ShikakuShutokuJogaishaKanriEntity entity;

    /**
     * 資格取得除外者一覧取得のEntity
     *
     * @param entity ShikakuShutokuJogaishaKanriEntity
     */
    public ShikakuShutokuJogaishaKanri(ShikakuShutokuJogaishaKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return entity.getRirekiNo();
    }

    /**
     * 氏名のgetメソッドです。
     *
     * @return 氏名
     */
    public AtenaMeisho getMeisho() {
        return entity.getMeisho();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    public RString getSeibetsuCode() {
        return Gender.toValue(entity.getSeibetsuCode()).getName().getShortJapanese();
    }

    /**
     * 住民状態のgetメソッドです。
     *
     * @return 住民状態
     */
    public RString getJuminJotaiCode() {
        return JuminJotai.toValue(entity.getJuminJotaiCode()).住民状態略称();
    }

    /**
     * 資格取得除外理由のgetメソッドです。
     *
     * @return 資格取得除外理由
     */
    public RString getShikakuShutokuJogaiRiyu() {
        return entity.getShikakuShutokuJogaiRiyu();
    }

    /**
     * 資格取得除外年月日のgetメソッドです。
     *
     * @return 資格取得除外年月日
     */
    public FlexibleDate getShikakuShutokuJogaiYMD() {
        return entity.getShikakuShutokuJogaiYMD();
    }

    /**
     * 資格取得除外解除年月日のgetメソッドです。
     *
     * @return 資格取得除外解除年月日
     */
    public FlexibleDate getShikakuShutokuJogaiKaijoYMD() {
        return entity.getShikakuShutokuJogaiKaijoYMD();
    }

}
