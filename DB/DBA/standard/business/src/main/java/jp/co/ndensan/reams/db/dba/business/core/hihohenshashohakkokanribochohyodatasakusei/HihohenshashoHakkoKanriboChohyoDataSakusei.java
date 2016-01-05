/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿_帳票データ作成のクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakkoKanriboChohyoDataSakusei {

    private final FlexibleDate 印刷日時;
    private final RString ページ数;
    private final RString 帳票タイトル;
    private final LasdecCode 市町村コード;
    private final RString 市町村名;
    private final RString ソート順１;
    private final RString ソート順２;
    private final RString ソート順３;
    private final RString ソート順４;
    private final RString ソート順５;
    private final RString 改頁１;
    private final RString 改頁２;
    private final RString 改頁３;
    private final RString 改頁４;
    private final RString 改頁５;
    private final List<AkasiHakouKanriEntity> akasiHakouKanriEntityList;
    private final RString 様式;

    /**
     * 非公開コンストラクタです。
     *
     * @param 印刷日時 FlexibleDate
     * @param ページ数 RString
     * @param 帳票タイトル RString
     * @param 市町村コード LasdecCode
     * @param 市町村名 RString
     * @param ソート順１ RString
     * @param ソート順２ RString
     * @param ソート順３ RString
     * @param ソート順４ RString
     * @param ソート順５ RString
     * @param 改頁１ RString
     * @param 改頁２ RString
     * @param 改頁３ RString
     * @param 改頁４ RString
     * @param 改頁５ RString
     * @param akasiHakouKanriEntityList List<AkasiHakouKanriEntity>
     * @param 様式 RString
     */
    private HihohenshashoHakkoKanriboChohyoDataSakusei(
            FlexibleDate 印刷日時,
            RString ページ数,
            RString 帳票タイトル,
            LasdecCode 市町村コード,
            RString 市町村名,
            RString ソート順１,
            RString ソート順２,
            RString ソート順３,
            RString ソート順４,
            RString ソート順５,
            RString 改頁１,
            RString 改頁２,
            RString 改頁３,
            RString 改頁４,
            RString 改頁５,
            List<AkasiHakouKanriEntity> akasiHakouKanriEntityList,
            RString 様式) {
        this.印刷日時 = 印刷日時;
        this.ページ数 = ページ数;
        this.帳票タイトル = 帳票タイトル;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.ソート順１ = ソート順１;
        this.ソート順２ = ソート順２;
        this.ソート順３ = ソート順３;
        this.ソート順４ = ソート順４;
        this.ソート順５ = ソート順５;
        this.改頁１ = 改頁１;
        this.改頁２ = 改頁２;
        this.改頁３ = 改頁３;
        this.改頁４ = 改頁４;
        this.改頁５ = 改頁５;
        this.akasiHakouKanriEntityList = akasiHakouKanriEntityList;
        this.様式 = 様式;
    }

    /**
     * 証発行管理帳票データリスト作成を生成します。
     *
     * @param 印刷日時 FlexibleDate
     * @param ページ数 RString
     * @param 帳票タイトル RString
     * @param 市町村コード LasdecCode
     * @param 市町村名 RString
     * @param ソート順１ RString
     * @param ソート順２ RString
     * @param ソート順３ RString
     * @param ソート順４ RString
     * @param ソート順５ RString
     * @param 改頁１ RString
     * @param 改頁２ RString
     * @param 改頁３ RString
     * @param 改頁４ RString
     * @param 改頁５ RString
     * @param akasiHakouKanriEntityList List<AkasiHakouKanriEntity>
     * @param 様式 RString
     * @return 証発行管理帳票データリスト
     */
    public static HihohenshashoHakkoKanriboChohyoDataSakusei createParam_ShohakkoKanriChohyoDataList(
            FlexibleDate 印刷日時,
            RString ページ数,
            RString 帳票タイトル,
            LasdecCode 市町村コード,
            RString 市町村名,
            RString ソート順１,
            RString ソート順２,
            RString ソート順３,
            RString ソート順４,
            RString ソート順５,
            RString 改頁１,
            RString 改頁２,
            RString 改頁３,
            RString 改頁４,
            RString 改頁５,
            List<AkasiHakouKanriEntity> akasiHakouKanriEntityList,
            RString 様式) {
        return new HihohenshashoHakkoKanriboChohyoDataSakusei(
                印刷日時,
                ページ数,
                帳票タイトル,
                市町村コード,
                市町村名,
                ソート順１,
                ソート順２,
                ソート順３,
                ソート順４,
                ソート順５,
                改頁１,
                改頁２,
                改頁３,
                改頁４,
                改頁５,
                akasiHakouKanriEntityList,
                様式
        );
    }
}
