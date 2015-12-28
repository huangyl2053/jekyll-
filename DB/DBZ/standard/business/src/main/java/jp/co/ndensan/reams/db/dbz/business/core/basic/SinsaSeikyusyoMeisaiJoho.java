/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査請求書明細情報を管理するクラスです。
 */
public class SinsaSeikyusyoMeisaiJoho {

    private final DbT7001FufukuMoshitateEntity entity;

    /**
     * コンストラクタです。<br/>
     * 不服審査申立情報の新規作成時に使用します。
     *
     * @param entity DbT7001FufukuMoshitateEntity
     */
    public SinsaSeikyusyoMeisaiJoho(DbT7001FufukuMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * 審査請求届出日を返します。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate get審査請求届出日() {
        return entity.getShinsaSeikyuTodokedeYMD();
    }

    /**
     * 審査請求人郵便番号を返します。
     *
     * @return 審査請求人郵便番号
     */
    public YubinNo get審査請求人郵便番号() {
        return entity.getShinsaSeikyuninYubinNo();
    }

    /**
     * 審査請求人住所を返します。
     *
     * @return 審査請求人住所
     */
    public AtenaJusho get審査請求人住所() {
        return entity.getShinsaSeikyuninJusho();
    }

    /**
     * 審査請求人氏名を返します。
     *
     * @return 審査請求人氏名
     */
    public AtenaMeisho get審査請求人氏名() {
        return entity.getShinsaSeikyuninShimei();
    }

    /**
     * 審査請求人電話番号を返します。
     *
     * @return 審査請求人電話番号
     */
    public TelNo get審査請求人電話番号() {
        return entity.getShinsaSeikyuninTelNo();
    }

    /**
     * 被保険者との関係コードを返します。
     *
     * @return 被保険者との関係コード
     */
    public RString get被保険者との関係コード() {
        return entity.getHihokenshaTonoKankeiCode();
    }

    /**
     * 被保険者との関係を返します。
     *
     * @return 被保険者との関係
     */
    public RString get被保険者との関係() {
        return entity.getHihokenshaTonoKankeiCode();
    }

    /**
     * 代理人郵便番号を返します。
     *
     * @return 代理人郵便番号
     */
    public YubinNo get代理人郵便番号() {
        return entity.getDairininYubinNo();
    }

    /**
     * 代理人住所を返します。
     *
     * @return 代理人住所
     */
    public AtenaJusho get代理人住所() {
        return entity.getDairininJusho();
    }

    /**
     * 代理人氏名を返します。
     *
     * @return 代理人氏名
     */
    public AtenaMeisho get代理人氏名() {
        return entity.getDairininShimei();
    }

    /**
     * 代理人電話番号を返します。
     *
     * @return 代理人電話番号
     */
    public TelNo get代理人電話番号() {
        return entity.getDairininTelNo();
    }

    /**
     * 処分庁を返します。
     *
     * @return 処分庁
     */
    public RString get処分庁() {
        return entity.getShobunCho();
    }

    /**
     * 処分日を返します。
     *
     * @return 処分日
     */
    public FlexibleDate get処分日() {
        return entity.getShobunYMD();
    }

    /**
     * 処分種類コードを返します。
     *
     * @return 処分種類コード
     */
    public RString get処分種類コード() {
        return entity.getShobunShuruiCode();
    }

    /**
     * 処分種類を返します。
     *
     * @return 処分種類
     */
    public RString get処分種類() {
        return entity.getShobunShuruiCode();
    }

    /**
     * 処分があったことを知った日を返します。
     *
     * @return 処分があったことを知った日
     */
    public FlexibleDate get処分があったことを知った日() {
        return entity.getShobunKakuninYMD();
    }

    /**
     * 審査請求の理由を返します。
     *
     * @return 審査請求の理由
     */
    public RString get審査請求の理由() {
        return entity.getShinsaSeikyuRiyu();
    }

    /**
     * 処分庁教示の有無及び教示の内容を返します。
     *
     * @return 処分庁教示の有無及び教示の内容
     */
    public RString get処分庁教示の有無及び教示の内容() {
        return entity.getShobunChoKyojiNaiyo();
    }

    /**
     * 添付書類等を返します。
     *
     * @return 添付書類等
     */
    public boolean get添付書類等() {
        return entity.getTempuShoruiTo();
    }

    /**
     * 審査請求取下日を返します。
     *
     * @return 審査請求取下日
     */
    public FlexibleDate get審査請求取下日() {
        return entity.getShinsaSeikyuTorisageYMD();
    }
}
