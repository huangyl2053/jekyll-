/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.hikazenenkintaishosha;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4037HikazeNenkinTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者を管理するクラスです。
 *
 * @reamsid_L DBX-9999-023 liangbc
 */
public class HikazeNenkinTaishosha {

    private DbT4037HikazeNenkinTaishoshaEntity entity;

    /**
     * コンストラクタです。<br/>
     * 非課税年金対象者の新規作成時に使用します。
     *
     * @param entity 非課税年金対象者
     */
    public HikazeNenkinTaishosha(DbT4037HikazeNenkinTaishoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * DT金額1を取得
     *
     * @return DT金額1
     */
    public RString getDT金額1() {
        return entity.getDtkingaku1();
    }

    /**
     * DTカナ氏名を取得
     *
     * @return DTカナ氏名
     */
    public RString getDTカナ氏名() {
        return entity.getDtkanashimei();
    }

    /**
     * DT漢字氏名を取得
     *
     * @return DT漢字氏名
     */
    public RString getDT漢字氏名() {
        return entity.getDtkanjishimei();
    }

    /**
     * DT生年月日を取得
     *
     * @return DT生年月日
     */
    public RString getDT生年月日() {
        return entity.getDtbirthday();
    }

    /**
     * DT性別を取得
     *
     * @return DT性別
     */
    public RString getDT性別() {
        return entity.getDtseibetsu();
    }

    /**
     * DT年金保険者コードを取得
     *
     * @return DT年金保険者コード
     */
    public RString getDT年金保険者コード() {
        return entity.getDtnenkinhokenshacode();
    }

    /**
     * 基礎年金番号を取得
     *
     * @return 基礎年金番号
     */
    public RString get基礎年金番号() {
        return entity.getKisonenkinno();
    }

    /**
     * 現基礎年金番号を取得
     *
     * @return 現基礎年金番号
     */
    public RString get現基礎年金番号() {
        return entity.getGenkisonenkinno();
    }

    /**
     * 年金コードを取得
     *
     * @return 年金コード
     */
    public RString get年金コード() {
        return entity.getNenkincode();
    }

    /**
     * DT通知内容コードを取得
     *
     * @return DT通知内容コード
     */
    public RString getDT通知内容コード() {
        return entity.getDttsuchinaiyocode();
    }

    /**
     * DT作成年月日を取得
     *
     * @return DT作成年月日
     */
    public RString getDT作成年月日() {
        return entity.getDtsakuseiymd();
    }

    /**
     * DT訂正表示を取得
     *
     * @return DT訂正表示
     */
    public RString getDT訂正表示() {
        return entity.getDtteiseihyoji();
    }

    /**
     * DT各種区分を取得
     *
     * @return DT各種区分
     */
    public RString getDT各種区分() {
        return entity.getDtkakushukubun();
    }

    /**
     * DT処理結果を取得
     *
     * @return DT処理結果
     */
    public RString getDT処理結果() {
        return entity.getDtshorikekka();
    }

    /**
     * DTカナ住所を取得
     *
     * @return DTカナ住所
     */
    public RString getDTカナ住所() {
        return entity.getDtkanajusho();
    }

    /**
     * DT漢字住所を取得
     *
     * @return DT漢字住所
     */
    public RString getDT漢字住所() {
        return entity.getDtkanjijusho();
    }

    /**
     * 登録区分を取得
     *
     * @return 登録区分
     */
    public RString get登録区分() {
        return entity.getTorokukubun();
    }

}
