/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者一時TBL
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0001HihokenshaTempEntity {

    private int 連番;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate サービス提供年月末日;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private LasdecCode 旧市町村コード;
    private HihokenshaNo 変換被保険者番号;
    private HihokenshaNo 登録被保険者番号;
    private LasdecCode 市町村コード;
    private RString 管内管外区分;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 行政区名;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 宛名カナ名称;
    private RString 宛名名称;
    private RString 氏名50音カナ;
    private RString 識別コード;
    private FlexibleDate 資格取得日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由コード;
    private RString 世帯集約番号;

    /**
     * DbWT0001HihokenshaIchijiEntityにかわる。
     *
     * @return DbWT0001HihokenshaIchijiEntity
     */
    public DbWT0001HihokenshaIchijiEntity toEntity() {
        DbWT0001HihokenshaIchijiEntity entity = new DbWT0001HihokenshaIchijiEntity();
        entity.setMeisaiRenban(連番);
        entity.setShoHokenshaNo(証記載保険者番号);
        entity.setOrgHihokenshaNo(被保険者番号);
        entity.setServiceTeikyoYmd(サービス提供年月末日);
        entity.setOrgHihokenshaKanaShimei(被保険者カナ氏名);
        entity.setOrgHihokenshaShimei(被保険者氏名);
        entity.setOldShichosonCode(旧市町村コード);
        entity.setHenkanHihokenshaNo(変換被保険者番号);
        entity.setHihokenshaNo(登録被保険者番号);
        entity.setShichosonCode(市町村コード);
        entity.setKannaiKangaiKubun(管内管外区分);
        entity.setYubinNo(郵便番号);
        entity.setChoikiCode(町域コード);
        entity.setGyoseikuCode(行政区コード);
        entity.setGyoseikuMei(行政区名);
        entity.setJusho(住所);
        entity.setBanchi(番地);
        entity.setKatagaki(方書);
        entity.setKanaMeisho(宛名カナ名称);
        entity.setMeisho(宛名名称);
        entity.setShimei50onKana(氏名50音カナ);
        if (null != 識別コード) {
            entity.setShikibetsuCode(new ShikibetsuCode(識別コード));
        }
        entity.setShikakuShutokuYmd(資格取得日);
        entity.setShikakuShutokuJiyuCode(資格取得事由コード);
        entity.setShikakuSoshitsuYmd(資格喪失日);
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
        if (null != 世帯集約番号) {
            entity.setSetaiShuyakuNo(new HihokenshaNo(世帯集約番号));
        }
        return entity;
    }

}
