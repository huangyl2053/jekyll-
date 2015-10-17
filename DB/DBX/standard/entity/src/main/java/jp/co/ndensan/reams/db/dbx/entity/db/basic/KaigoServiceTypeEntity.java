/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * 介護サービス種類マスタの内容を持つエンティティです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護サービスタイプエンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス種類
 * @mainClass
 * @reference
 */
@OnRshareSchema
public class KaigoServiceTypeEntity {

    /**
     * サービス種類コード
     */
    private RString serviceTypeCd;
    /**
     * 提供開始年月
     */
    private RDate teikyoKaishiYM;
    /**
     * サービス種類名称
     */
    private RString serviceTypeMeisho;
    /**
     * サービス種類略称
     */
    private RString serviceTypeRyakusho;
    /**
     * サービス分類
     */
    private RString serviceBunrui;

    /**
     * 介護サービス種類エンティティのコンストラクタです。
     *
     * @param serviceTypeCd サービス種類コード
     * @param teikyoKaishiYM 提供開始年月
     * @param serviceTypeMeisho サービス種類名称
     * @param serviceTypeRyakusho サービス種類略称
     * @param serviceBunrui サービス分類
     */
    public KaigoServiceTypeEntity(RString serviceTypeCd, RDate teikyoKaishiYM,
            RString serviceTypeMeisho, RString serviceTypeRyakusho, RString serviceBunrui) {
        this.serviceTypeCd = requireNonNull(serviceTypeCd, UrSystemErrorMessages.値がnull.getReplacedMessage("serviceTypeCd"));
        this.teikyoKaishiYM = requireNonNull(teikyoKaishiYM, UrSystemErrorMessages.値がnull.getReplacedMessage("teikyoKaishiYM"));
        this.serviceTypeMeisho = requireNonNull(serviceTypeMeisho, UrSystemErrorMessages.値がnull.getReplacedMessage("serviceTypeMeisho"));
        this.serviceTypeRyakusho = requireNonNull(serviceTypeRyakusho, UrSystemErrorMessages.値がnull.getReplacedMessage("serviceTypeRyakusho"));
        this.serviceBunrui = requireNonNull(serviceBunrui, UrSystemErrorMessages.値がnull.getReplacedMessage("serviceBunrui"));
    }

    /**
     * サービス種類コードを返します。
     *
     * @return serviceTypeCd
     */
    public RString getサービス種類コード() {
        return serviceTypeCd;
    }

    /**
     * 提供開始年月を返します。
     *
     * @return teikyoKaishiYM
     */
    public RDate get提供開始年月() {
        return teikyoKaishiYM;
    }

    /**
     * サービス種類名称を返します。
     *
     * @return serviceTypeMeisho
     */
    public RString getサービス種類名称() {
        return serviceTypeMeisho;
    }

    /**
     * サービス種類略称を返します。
     *
     * @return serviceTypeRyakusho
     */
    public RString getサービス種類略称() {
        return serviceTypeRyakusho;
    }

    /**
     * サービス分類を返します。
     *
     * @return serviceBunrui
     */
    public RString getサービス分類() {
        return serviceBunrui;
    }
}
