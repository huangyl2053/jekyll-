/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaRelate {

    private final TekiyoJogaishaRelateEntity relateEntity;

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param relateEntity {@link TekiyoJogaishaRelateEntity}
     */
    public TekiyoJogaishaRelate(
            TekiyoJogaishaRelateEntity relateEntity
    ) {
        this.relateEntity = relateEntity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return relateEntity.getShikibetsuCode();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return relateEntity.getJigyoshaMeisho();
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return relateEntity.getNyushoYMD();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return relateEntity.getNyushoShisetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return relateEntity.getRirekiNo();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return relateEntity.getEdaNo();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return relateEntity.getIdoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return relateEntity.getKaijoTodokedeYMD();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return relateEntity.getKaijoYMD();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return relateEntity.getTaishoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return relateEntity.getTekiyoTodokedeYMD();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return relateEntity.getTekiyoYMD();
    }

    /**
     * 適用除外解除事由コードを返します。
     *
     * @return 適用除外解除事由コード
     */
    public RString get適用除外解除事由コード() {
        return relateEntity.getTekiyoJogaikaijokaijoJiyuCode();
    }

    /**
     * 適用除外適用事由コードを返します。
     *
     * @return 適用除外適用事由コード
     */
    public RString get適用除外適用事由コード() {
        return relateEntity.getTekiyoJogaiTekiyoJiyuCode();
    }
}
