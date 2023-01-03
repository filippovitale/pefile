package pefile.codec

import scodec.bits._
import scodec.{Codec, SizeBound}
import scodec.codecs._
import scodec.codecs.literals._

//import scodec.stream._

import shapeless._

case class MSDosHeader(ihl: Short)

object MSDosHeader {

  implicit val codec: Codec[MSDosHeader] = {
    //Magic Number / File ID Tag "MZ"
    ("signature" | hex"4d5a") :~>:
      ("ihl" | short16) /*::
      ("lastsize" | short16) ::
      ("nblocks" | short16) ::
      ("nreloc" | short16) ::
      ("hdrsize" | short16) ::
      ("minalloc" | short16) ::
      ("maxalloc" | short16) ::
      ("ss" | ignore(32)) ::
      ("sp" | ignore(32)) ::
      ("checksum" | short16) ::
      ("ip" | ignore(32)) ::
      ("cs" | ignore(32)) ::
      ("relocpos" | short16) ::
      ("noverlay" | short16) ::
      ("reserved1" | vectorOfN(provide(4), short16)) ::
      ("oem_id" | short16) ::
      ("oem_info" | short16) ::
      ("reserved2" | vectorOfN(provide(10), short16)) ::
      ("e_lfanew" | long(32))*/
  }.as[MSDosHeader]

}
