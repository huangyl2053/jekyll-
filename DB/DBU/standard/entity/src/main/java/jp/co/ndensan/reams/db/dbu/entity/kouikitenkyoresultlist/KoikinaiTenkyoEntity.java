/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内転居結果Entity
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoEntity {

    private HihokenshaNo 被保険者番号;
    private AtenaKanaMeisho 氏名カナ;
    private AtenaMeisho 氏名;
    private ShikibetsuCode 旧住民コード;
    private RString 前住所;
    private FlexibleDate 転出予定日;
    private FlexibleDate 転出確定日;
    private FlexibleDate 転出確定通知日;
    private FlexibleDate 処理日;
    private ShikibetsuCode 新住民コード;
    private RString 現住所;
    private FlexibleDate 登録異動日;
    private FlexibleDate 登録届出日;
    private RString 異動情報;
    private FlexibleDate 印刷日時;

    /**
     * KoikinaiTenkyoEntity
     *
     * @param 被保険者番号 被保険者番号
     * @param 氏名カナ 氏名カナ
     * @param 氏名 氏名
     * @param 旧住民コード 旧住民コード
     * @param 前住所 前住所
     * @param 転出予定日 転出予定日
     * @param 転出確定日 転出確定日
     * @param 転出確定通知日 転出確定通知日
     * @param 処理日 処理日
     * @param 新住民コード 新住民コード
     * @param 現住所 現住所
     * @param 登録異動日 登録異動日
     * @param 登録届出日 登録届出日
     * @param 異動情報 異動情報
     */
    public KoikinaiTenkyoEntity(HihokenshaNo 被保険者番号,
            AtenaKanaMeisho 氏名カナ,
            AtenaMeisho 氏名,
            ShikibetsuCode 旧住民コード,
            RString 前住所,
            FlexibleDate 転出予定日,
            FlexibleDate 転出確定日,
            FlexibleDate 転出確定通知日,
            FlexibleDate 処理日,
            ShikibetsuCode 新住民コード,
            RString 現住所,
            FlexibleDate 登録異動日,
            FlexibleDate 登録届出日,
            RString 異動情報) {
        this.被保険者番号 = 被保険者番号;
        this.氏名カナ = 氏名カナ;
        this.氏名 = 氏名;
        this.旧住民コード = 旧住民コード;
        this.前住所 = 前住所;
        this.転出予定日 = 転出予定日;
        this.転出確定日 = 転出確定日;
        this.転出確定通知日 = 転出確定通知日;
        this.処理日 = 処理日;
        this.新住民コード = 新住民コード;
        this.現住所 = 現住所;
        this.登録異動日 = 登録異動日;
        this.登録届出日 = 登録届出日;
        this.異動情報 = 異動情報;

    }

}
