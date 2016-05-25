package jp.co.ndensan.reams.db.dbe.entity.db.relate.taisyosyajidowaritsuke;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象者自動割付の取得のEntityクラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaisyosyaJidoWaritsukeEntity {

    private Code yusenWaritsukeKubunCode;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private RString hihokenshaKubunCode;
    private Code shinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private FlexibleDate zenkaiYukoKikanStart;
    private FlexibleDate zenkaiYukoKikanEnd;
    private FlexibleDate ichijiHanteiYMD;
    private FlexibleDate maskingKanryoYMD;
    private RString shichosonMeisho;
    private Code ninchishoJiritsudoCode;
    private Code shogaiJiritsudoCode;
    private int remban;
    private RString ikenItem;
    private JigyoshaNo nyushoShisetsuCode;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private int saiChosaIraiKaisu;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private RString shoKisaiHokenshaNo;
    private ShinseishoKanriNo shinseishoKanriNo;
}
